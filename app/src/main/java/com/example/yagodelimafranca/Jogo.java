package com.example.yagodelimafranca;

import android.content.Context;
import android.content.res.Resources;

public class Jogo {
    private int tentativas = 0;
    private int potuacao = 30;

    private String palavraCorreta;
    private String nomeJogador;

    private String dica1;

    private String dica2;
    private String dica3;
    private String tema;
    public Jogo(String[] lista) {
        tema = lista[0];
        palavraCorreta = lista[1];
        dica1 = lista[2];
        dica2 = lista[3];
        dica3 = lista[4];
    }

    public int getSmiley() {
        int smiley;
        if (potuacao == 30) {
            smiley = R.drawable.smiley_sorridente;
        } else if (potuacao > 0) {
            smiley = R.drawable.smiley_apatico;
        } else {
            smiley = R.drawable.smiley_triste;
        }
        return smiley;

    }

    public void calcularPontuacao() {
        if (tentativas > 0) {
            potuacao -= 10;
        }
    }

    public boolean verificarPalavra(String palavra) {
        tentativas++;
        if (palavra.trim().equalsIgnoreCase(palavraCorreta)) {
            return true;
        } else {
            calcularPontuacao();
            return false;
        }
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public String getPalavraCorreta() {
        return palavraCorreta;
    }

    public void setPalavraCorreta(String palavraCorreta) {
        this.palavraCorreta = palavraCorreta;
    }

    public String getDica1() {
        return dica1;
    }

    public void setDica1(String dica1) {
        this.dica1 = dica1;
    }

    public String getDica2() {
        return dica2;
    }

    public void setDica2(String dica2) {
        this.dica2 = dica2;
    }

    public String getDica3() {
        return dica3;
    }

    public void setDica3(String dica3) {
        this.dica3 = dica3;
    }

    public int getPotuacao() {
        return potuacao;
    }

    public void setPotuacao(int potuacao) {
        this.potuacao = potuacao;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
