package com.example.yagodelimafranca;

import java.io.Serializable;

public class Partida implements Serializable {

    private String nome;
    private int pontos;
    private int smiley;

    public Partida(String nome, int pontos, int smiley) {
        this.nome = nome;
        this.pontos = pontos;
        this.smiley = smiley;
    }

    public int getSmiley() {
        return smiley;
    }

    public void setSmiley(int smiley) {
        this.smiley = smiley;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "nome='" + nome + '\'' +
                ", pontos=" + pontos +
                '}';
    }
}
