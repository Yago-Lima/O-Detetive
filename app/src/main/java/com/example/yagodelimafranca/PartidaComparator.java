package com.example.yagodelimafranca;

import java.util.Comparator;

public class PartidaComparator implements Comparator<Partida> {
    @Override
    public int compare(Partida p1, Partida p2) {
        return p2.getPontos() - p1.getPontos();
    }
}
