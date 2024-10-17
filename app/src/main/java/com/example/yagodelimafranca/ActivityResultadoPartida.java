package com.example.yagodelimafranca;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityResultadoPartida extends AppCompatActivity {
    Toolbar mytoolbar;
    TextView textViewResultado;
    ImageView imageViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_partida);
        textViewResultado = findViewById(R.id.textViewResultado);
        imageViewResultado = findViewById(R.id.imageViewResultado);

        Intent it = getIntent();
        int smiley = it.getIntExtra(getString(R.string.smiley), 0);

        imageViewResultado.setImageResource(smiley);

        if (smiley == R.drawable.smiley_sorridente) {
            textViewResultado.setText(R.string.acertou);
        } else if(smiley == R.drawable.smiley_apatico){
            textViewResultado.setText(R.string.quase_errou);
        }else{
            textViewResultado.setText(R.string.errou);
        }

        mytoolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(mytoolbar);

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