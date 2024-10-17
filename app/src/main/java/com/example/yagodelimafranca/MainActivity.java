package com.example.yagodelimafranca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextNome;
    Button buttonJogar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.editTextNome);
        buttonJogar = findViewById(R.id.buttonJogar);

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ActivityJogo.class);
                it.putExtra("nome", editTextNome.getText().toString());
                int num = Utils.gerarNumAleatorio();
                it.putExtra("num",num);
                Toast.makeText(MainActivity.this, "Numero gerado <"+num+">", Toast.LENGTH_SHORT).show();
                startActivity(it);
            }//onClick
        });

    }//onCreate
}//class