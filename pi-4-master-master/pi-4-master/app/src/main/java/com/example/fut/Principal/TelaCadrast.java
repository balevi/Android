package com.example.fut.Principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fut.Principal.Cadast_Boleiro;
import com.example.fut.R;

public class TelaCadrast extends AppCompatActivity {
    Button btnBoleiro;
    Button btnBusc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadrast);
        btnBoleiro = findViewById(R.id.btnBoleiro);
        btnBusc = findViewById(R.id.btnBusc);
        btnBusc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickcontrat();
            }
        });
        btnBoleiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickboleiro();
            }
        });

    }

    public void clickboleiro() {
        Intent intent = new Intent(this, Cadast_Boleiro.class);
        startActivity(intent);
    }

    public void clickcontrat() {
        Intent intent = new Intent(this, CadastContrat.class);
        startActivity(intent);
    }





}