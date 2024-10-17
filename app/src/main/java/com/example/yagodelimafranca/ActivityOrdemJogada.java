package com.example.yagodelimafranca;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ActivityOrdemJogada extends AppCompatActivity {
    Toolbar mytoolbar;
    ListView listViewPontuacao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem_jogada);
        listViewPontuacao = findViewById(R.id.listViewPontuacao);
        mytoolbar = findViewById(R.id.mytoolbar);

        mytoolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("Ordem de jogada");

        AppContext appContextContext = (AppContext) getApplicationContext();
        ArrayList<Partida> partidas = appContextContext.getPartidas();

        MyAdapter adapter = new MyAdapter(this, partidas);
        listViewPontuacao.setAdapter(adapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent it;
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            it = new Intent(this, MainActivity.class);
            startActivity(it);
        }
        switch (item.getTitle().toString()) {
            case "Jogar Novamente":
                MyDialogFragment mdf = new MyDialogFragment();
                mdf.show(getSupportFragmentManager(), "dialog");
                break;
            case "Ver pontuação":
                it = new Intent(this, ActivityPontuacao.class);
                startActivity(it);
            case "sair":
                finishAffinity();
        }
        return true;
    }
}