package com.mycompany.servidortcp;
import com.google.gson.Gson;

// O que o SERVIDOR envia ao cliente.
// tipo: "OK" | "ERRO" | "MSG" | "PRIVADA" | "SISTEMA" | "USUARIOS"
public class Resposta {
    private String tipo;
    private String hora;
    private String remetente;
    private String texto;

    public Resposta(String tipo, String hora, String remetente, String texto) {
        this.tipo = tipo;
        this.hora = hora;
        this.remetente = remetente;
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getHora() {
        return hora;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getTexto() {
        return texto;
    }

    public String paraLinha() {
        return new Gson().toJson(this);
    }

    public static Resposta deLinha(String linha) {
        return new Gson().fromJson(linha, Resposta.class);
    }
}
