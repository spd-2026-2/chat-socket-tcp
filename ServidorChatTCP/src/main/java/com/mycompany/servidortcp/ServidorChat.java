package com.mycompany.servidortcp;

import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorChat {

    private static ArrayList<AtendimentoCliente> clientes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(6000);
        ExecutorService pool = Executors.newFixedThreadPool(10);

        System.out.println("Servidor de chat iniciado na porta 6000.");

        while (true) {
            Socket cliente = servidor.accept();
            pool.execute(new AtendimentoCliente(cliente));
        }
    }

    public static synchronized AtendimentoCliente buscar(String nickname) {
        for (AtendimentoCliente c : clientes) {
            if (c.getNickname().equalsIgnoreCase(nickname)) {
                return c;
            }
        }
        return null;
    }

    public static synchronized boolean adicionar(AtendimentoCliente cliente) {
        if (buscar(cliente.getNickname()) != null) {
            return false;
        }

        clientes.add(cliente);
        return true;
    }

    public static synchronized void remover(AtendimentoCliente cliente) {
        clientes.remove(cliente);
    }

    public static synchronized void enviarParaTodos(Resposta resposta) {
        for (AtendimentoCliente c : clientes) {
            c.enviar(resposta);
        }
    }

    public static synchronized void enviarListaUsuarios() {
        String nomes = "";

        for (AtendimentoCliente c : clientes) {
            if (!nomes.isEmpty()) {
                nomes += ",";
            }
            nomes += c.getNickname();
        }

        enviarParaTodos(new Resposta("USUARIOS", agora(), "servidor", nomes));
    }

    public static String agora() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}