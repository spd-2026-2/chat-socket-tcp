package com.mycompany.servidortcp;
import com.google.gson.Gson;

// O que o CLIENTE envia ao servidor.
// tipo: "entrar" | "todos" | "privada"
public class Requisicao {
    private String tipo;
    private String nickname;
    private String destinatario;
    private String texto;

    public Requisicao(String tipo, String nickname, String destinatario, String texto) {
        this.tipo = tipo;
        this.nickname = nickname;
        this.destinatario = destinatario;
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNickname() {
        return nickname;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getTexto() {
        return texto;
    }

    public String paraLinha() {
        return new Gson().toJson(this);
    }

    public static Requisicao deLinha(String linha) {
        return new Gson().fromJson(linha, Requisicao.class);
    }
}
