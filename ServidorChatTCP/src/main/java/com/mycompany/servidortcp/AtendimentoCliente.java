package com.mycompany.servidortcp;

import java.io.*;
import java.net.Socket;

public class AtendimentoCliente implements Runnable {

    private Socket cliente;
    private PrintWriter saida;
    private String nickname = "";

    public AtendimentoCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public String getNickname() {
        return nickname;
    }
    
    //mensagem volta para o cliente que enviou
    public synchronized void enviar(Resposta resposta) {
        saida.println(resposta.paraLinha());
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            saida = new PrintWriter(cliente.getOutputStream(), true);

            String linha;

            while ((linha = entrada.readLine()) != null) { //quando conexão encerra readLine retorna null
                Requisicao req = Requisicao.deLinha(linha);

                if (req.getTipo().equals("entrar")) {
                    nickname = req.getNickname();

                    if (!ServidorChat.adicionar(this)) {
                        enviar(new Resposta("ERRO", ServidorChat.agora(), "servidor", "Nickname já utilizado."));
                        nickname = "";
                        break;
                    }
                    
                    //mensagem volta para o cliente que enviou (o que está sendo atendido)
                    enviar(new Resposta("OK", ServidorChat.agora(), "servidor", "Bem-vindo(a) ao chat!"));
                    
                    ServidorChat.enviarParaTodos(new Resposta("SISTEMA", ServidorChat.agora(), "servidor", nickname + " entrou no chat"));
                    ServidorChat.enviarListaUsuarios();
                }

                if (req.getTipo().equals("todos")) {
                    ServidorChat.enviarParaTodos(new Resposta("PUBLICA", ServidorChat.agora(), nickname, req.getTexto()));
                }

                if (req.getTipo().equals("privada")) {
                    AtendimentoCliente destino = ServidorChat.buscar(req.getDestinatario());

                    if (destino == null) {
                        enviar(new Resposta("ERRO", ServidorChat.agora(), "servidor", "Usuário não encontrado."));
                    } else {
                        destino.enviar(new Resposta("PRIVADA", ServidorChat.agora(), nickname, req.getTexto()));
                        enviar(new Resposta("PRIVADA", ServidorChat.agora(), "você → " + destino.getNickname(), req.getTexto()));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Cliente desconectado.");
        } finally {
            if (!nickname.isEmpty()) {
                ServidorChat.remover(this);
                ServidorChat.enviarParaTodos(new Resposta("SISTEMA", ServidorChat.agora(), "servidor", nickname + " saiu do chat"));
                ServidorChat.enviarListaUsuarios();
            }

            try {
                cliente.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar conexão.");
            }
        }
    }
}