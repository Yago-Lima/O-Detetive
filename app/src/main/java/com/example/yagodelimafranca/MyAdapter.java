package com.example.yagodelimafranca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Partida> partidas;

    public MyAdapter(Context context, ArrayList<Partida> itens) {
        this.partidas = itens;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return partidas.size();
    }

    @Override
    public Object getItem(int position) {
        return partidas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Partida partida = partidas.get(position);
        convertView = inflater.inflate(R.layout.item_lista, null);
        TextView nome = convertView.findViewById(R.id.nome);
        nome.setText(partida.getNome());
        ImageView smiley = convertView.findViewById(R.id.imagem);
        smiley.setImageResource(partida.getSmiley());
        TextView pontos = convertView.findViewById(R.id.pontos);
        pontos.setText(String.valueOf(partida.getPontos()));
        return convertView;
    }
}
