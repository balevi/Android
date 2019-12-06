package com.example.fut.Principal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fut.R;
import com.example.fut.FragmentCadast.gandula;
import com.example.fut.FragmentCadast.goleiro;
import com.example.fut.FragmentCadast.juiz;
import com.example.fut.FragmentCadast.linha;

public class Cadast_Boleiro extends AppCompatActivity {
    Button btnGoleiro;
    Button btnLinha;
    Button btnGandula;
    Button btnJuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadast__boleiro);
        //----------------------------------------------------//
        btnGoleiro = findViewById(R.id.btnGoleiro);
        btnLinha = findViewById(R.id.btnLinha);
        btnGandula = findViewById(R.id.btnGandula);
        btnJuiz = findViewById(R.id.btnJuiz);
        //----------------------------------------------------//
        btnGoleiro.setOnClickListener(clickgoleiro);
        btnLinha.setOnClickListener(clicklinha);
        btnGandula.setOnClickListener(clickgandula);
        btnJuiz.setOnClickListener(clickjuiz);

    }
    View.OnClickListener clickgoleiro = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm= getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, goleiro.newInstance());
            ft.commit();

        }
    };
    View.OnClickListener clicklinha = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm= getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, linha.newInstance());
            ft.commit();

        }
    };
    View.OnClickListener clickgandula = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm= getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, gandula.newInstance());
            ft.commit();

        }
    };
    View.OnClickListener clickjuiz = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm= getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, juiz.newInstance());
            ft.commit();

        }
    };

}
