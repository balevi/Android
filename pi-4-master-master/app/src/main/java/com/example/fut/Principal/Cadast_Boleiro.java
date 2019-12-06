package com.example.fut.Principal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    TextView txtcont;
    TextView txtlin;
    TextView txtjui;
    TextView txtgan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadast__boleiro);

        //----------------------------------------------------//
        txtcont = findViewById(R.id.txtcont);
        txtlin = findViewById(R.id.txtlin);
        txtjui = findViewById(R.id.txtjui);
        txtgan = findViewById(R.id.txtgan);


        //----------------------------------------------------//
        txtcont.setVisibility(View.VISIBLE);
        txtlin.setVisibility(View.INVISIBLE);
        txtjui.setVisibility(View.INVISIBLE);
        txtgan.setVisibility(View.INVISIBLE);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, goleiro.newInstance());
        ft.commit();
    }
    /*View.OnClickListener clickgoleiro = new View.OnClickListener() {
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
*/

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_cadastro,menu);
        return true;

    }
    public void listcadGol (MenuItem item){
        txtcont.setVisibility(View.VISIBLE);
        txtlin.setVisibility(View.INVISIBLE);
        txtjui.setVisibility(View.INVISIBLE);
        txtgan.setVisibility(View.INVISIBLE);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, goleiro.newInstance());
        ft.commit();
    }

    public void listcadlin (MenuItem item){
        txtlin.setVisibility(View.VISIBLE);
        txtcont.setVisibility(View.INVISIBLE);
        txtjui.setVisibility(View.INVISIBLE);
        txtgan.setVisibility(View.INVISIBLE);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, linha.newInstance());
        ft.commit();
    }

    public void listcadjui (MenuItem item){
        txtjui.setVisibility(View.VISIBLE);
        txtcont.setVisibility(View.INVISIBLE);
        txtlin.setVisibility(View.INVISIBLE);
        txtgan.setVisibility(View.INVISIBLE);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, juiz.newInstance());
        ft.commit();
    }
    public void listcadgand (MenuItem item){
        txtgan.setVisibility(View.VISIBLE);
        txtcont.setVisibility(View.INVISIBLE);
        txtlin.setVisibility(View.INVISIBLE);
        txtjui.setVisibility(View.INVISIBLE);
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, gandula.newInstance());
        ft.commit();
    }

}
