package com.mycompany.clientechat;

import java.io.*;
import java.net.Socket;

public class ClienteChat {

    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter saida;

    public void conectar(String ip, int porta) throws IOException {
        socket = new Socket(ip, porta);

        entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        saida = new PrintWriter(socket.getOutputStream(), true);
    }

    public void enviar(Requisicao req) throws IOException {
        // Envia o objeto convertido em JSON
        saida.println(req.paraLinha());

        if (saida.checkError()) {
            throw new IOException("Falha ao enviar requisição.");
        }
        // No chat, a resposta NÃO é lida aqui: ela chega pela thread de escuta
    }

    // Aguarda a próxima mensagem do servidor (null = conexão encerrada)
    public Resposta receber() throws IOException {
        String linha = entrada.readLine();

        if (linha == null) {
            return null;
        }
        return Resposta.deLinha(linha);
    }

    public void desconectar() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
