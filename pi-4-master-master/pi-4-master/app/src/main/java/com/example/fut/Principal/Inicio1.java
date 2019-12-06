package com.example.fut.Principal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.fut.FragmentList.GandulaFragList;
import com.example.fut.FragmentList.GoleiroFragList;
import com.example.fut.FragmentList.JuizFragList;
import com.example.fut.FragmentList.LinhaFragListFragment;
import com.example.fut.R;


public class Inicio1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio1);

    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_principal,menu);
        return true;

    }
    public void listGol (MenuItem item){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1, GoleiroFragList.newInstance());
        ft.commit();
    }

    public void listlin (MenuItem item){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1, LinhaFragListFragment.newInstance());
        ft.commit();
    }

    public void listjui (MenuItem item){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1, JuizFragList.newInstance());
        ft.commit();
    }
    public void listgand (MenuItem item){
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame1, GandulaFragList.newInstance());
        ft.commit();
    }

}