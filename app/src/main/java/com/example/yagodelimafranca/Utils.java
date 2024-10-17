package com.example.yagodelimafranca;

import android.content.Context;
import android.content.res.Resources;

import java.util.Random;

public class Utils {
    public static int gerarNumAleatorio(){
        return new Random().nextInt(9) + 1;
    }
    public static String[] buscarPerguntas(Context context, int selecionado) {
        String[] lista = new String[0];
        Resources res = context.getResources();
        switch (selecionado) {
            case 1:
                lista = res.getStringArray(R.array.pergunta1);
                break;
            case 2:
                lista = res.getStringArray(R.array.pergunta2);
                break;
            case 3:
                lista = res.getStringArray(R.array.pergunta3);
                break;
            case 4:
                lista = res.getStringArray(R.array.pergunta4);
                break;
            case 5:
                lista = res.getStringArray(R.array.pergunta5);
                break;
            case 6:
                lista = res.getStringArray(R.array.pergunta6);
                break;
            case 7:
                lista = res.getStringArray(R.array.pergunta7);
                break;
            case 8:
                lista = res.getStringArray(R.array.pergunta8);
                break;
            case 9:
                lista = res.getStringArray(R.array.pergunta9);
                break;
            case 10:
                lista = res.getStringArray(R.array.pergunta10);
                break;
        }
        return lista;
    }
}
