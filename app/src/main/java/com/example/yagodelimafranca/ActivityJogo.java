package com.example.yagodelimafranca;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class ActivityJogo extends AppCompatActivity {
    Toolbar mytoolbar;
    ImageView imageViewCoracao1, imageViewCoracao2, imageViewCoracao3;
    TextView tema, dica1, dica2, dica3;
    Button buttonTentar;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        mytoolbar = findViewById(R.id.mytoolbar);
        Jogo jogoAtual;

        imageViewCoracao1 = findViewById(R.id.coracao1);
        imageViewCoracao2 = findViewById(R.id.coracao2);
        imageViewCoracao3 = findViewById(R.id.coracao3);
        ImageView[] coracoes = {imageViewCoracao1, imageViewCoracao2, imageViewCoracao3};

        tema = findViewById(R.id.tema);

        dica1 = findViewById(R.id.dica1);
        dica2 = findViewById(R.id.dica2);
        dica3 = findViewById(R.id.dica3);

        buttonTentar = findViewById(R.id.buttonTentar);

        it = getIntent();
        String[] lista = new String[0];
        int numSelecionado;
        String nomeJogador = null;

        try {
            nomeJogador = it.getStringExtra("nome");
            numSelecionado = it.getIntExtra("num", 0);
            lista = Utils.buscarPerguntas(this, numSelecionado);
            setSupportActionBar(mytoolbar);
            getSupportActionBar().setTitle("Detetive: " + nomeJogador);
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e);
        }

        jogoAtual = new Jogo(lista);

        jogoAtual.setNomeJogador(nomeJogador);
        tema.setText(jogoAtual.getTema());
        dica1.setText(jogoAtual.getDica1());
        dica2.setText(jogoAtual.getDica2());
        dica3.setText(jogoAtual.getDica3());
        TextView[] dicas = {dica2, dica3};//  as 2 dicas que ficam ocultas por padrão

        /*Insiro a lista no contexto da Aplicacao para "persistir" as partidas
        * enquanto o app estiver ativo*/
        AppContext appContextContext = (AppContext) getApplicationContext();
        ArrayList<Partida> partidas = appContextContext.getPartidas();
        buttonTentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String palpite = ((EditText) findViewById(R.id.editTextPalpite)).getText().toString();

                int tentativas = jogoAtual.getTentativas();
                if (jogoAtual.verificarPalavra(palpite) && tentativas != 2) {
                    Toast.makeText(ActivityJogo.this, "Você Ganhou!", Toast.LENGTH_SHORT).show();
                    partidas.add(new Partida(jogoAtual.getNomeJogador(), jogoAtual.getPotuacao(), jogoAtual.getSmiley()));
                    iniciarItent(jogoAtual);
                } else {
                    if (tentativas <= 2) {
                        coracoes[tentativas].setImageResource(R.drawable.coracao_escurecido);
                        if (tentativas == 2) {
                            Toast.makeText(ActivityJogo.this, "Você Perdeu!", Toast.LENGTH_SHORT).show();
                            partidas.add(new Partida(jogoAtual.getNomeJogador(), jogoAtual.getPotuacao(), jogoAtual.getSmiley()));
                            iniciarItent(jogoAtual);
                        }
                        if (tentativas < 2) {
                            dicas[tentativas].setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
    }

    public void iniciarItent(Jogo jogoAtual) {
        it = new Intent(ActivityJogo.this, ActivityResultadoPartida.class);
        it.putExtra(getString(R.string.smiley), jogoAtual.getSmiley());
        startActivity(it);
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