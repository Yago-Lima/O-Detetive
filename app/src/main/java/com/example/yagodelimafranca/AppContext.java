package com.example.yagodelimafranca;

import android.app.Application;

import java.util.ArrayList;

public class AppContext extends Application {
    private ArrayList<Partida> partidas;

    @Override
    public void onCreate() {
        super.onCreate();
        partidas = new ArrayList<>();
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }
}
