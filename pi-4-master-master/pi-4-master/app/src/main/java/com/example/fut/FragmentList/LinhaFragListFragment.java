package com.example.fut.FragmentList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fut.Adaptadores.LinhaAdapter;
import com.example.fut.Banco.LinhaDao;
import com.example.fut.Banco.Linha_class;
import com.example.fut.R;

import java.util.ArrayList;
import java.util.List;


public class LinhaFragListFragment extends Fragment {
    private ListView listView;
    private LinhaDao dao;
    private List<Linha_class> linhaClasses;
    private List<Linha_class> linhaClassesFiltrados = new ArrayList<>();
    private Button Rank3;
    private Button Rank4;



    public LinhaFragListFragment() {

    }


    public static LinhaFragListFragment newInstance() {
        LinhaFragListFragment fragment = new LinhaFragListFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_linhafraglist, container, false);


        listView = v.findViewById(R.id.ListaLinha);
        Rank3 = v.findViewById(R.id.Rank3);
        Rank4 = v.findViewById(R.id.Rank4);
        dao = new LinhaDao(this.getActivity());
        linhaClasses = dao.obterTodos();
        linhaClassesFiltrados.addAll(linhaClasses);

        //ArrayAdapter<Linha_class> adaptador = new ArrayAdapter<Linha_class>(this.getActivity(),android.R.layout.simple_list_item_1,linhaClasses);
        LinhaAdapter adaptador = new LinhaAdapter(getActivity(),linhaClassesFiltrados);
        listView.setAdapter(adaptador);


        Rank3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efeitolike();
            }
        });
        Rank4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efeitodeslike();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Linha_class lc = linhaClasses.get(i);

                       AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity());
                alerta.setIcon(R.drawable.jogador);
                alerta.setTitle("O QUE ACHOU DESSE JOGADOR?");
        //alerta.setMessage("GOSTOU OU NÃO GOSTOU?");
        alerta.setPositiveButton("GOSTEI!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "CURTIU", Toast.LENGTH_SHORT).show();
                dao.like(lc);
                linhaClasses = dao.obterTodos();
                linhaClassesFiltrados.clear();
                linhaClassesFiltrados.addAll(linhaClasses);
                listView.invalidateViews();
            }
        });
        alerta.setNegativeButton("NÃO GOSTEI!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(), "DESCURTIU", Toast.LENGTH_SHORT).show();
                dao.Deslike(lc);
                linhaClasses = dao.obterTodos();
                linhaClassesFiltrados.clear();
                linhaClassesFiltrados.addAll(linhaClasses);
                listView.invalidateViews();
            }
        });
        alerta.setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        //AlertDialog alertaDialog = alerta.create();
        alerta.show();



    }
});


        return v;
    }

    public void efeitolike (){
        linhaClasses = dao.obterTodos1();
        LinhaAdapter adaptador = new LinhaAdapter(getActivity(),linhaClassesFiltrados);
        listView.setAdapter(adaptador);
        linhaClassesFiltrados.clear();
        linhaClassesFiltrados.addAll(linhaClasses);
        listView.invalidateViews();

    }

    public void efeitodeslike (){
        linhaClasses = dao.obterTodos2();
        LinhaAdapter adaptador = new LinhaAdapter(getActivity(),linhaClassesFiltrados);
        listView.setAdapter(adaptador);
        linhaClassesFiltrados.clear();
        linhaClassesFiltrados.addAll(linhaClasses);
        listView.invalidateViews();

    }


}
