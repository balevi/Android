package com.example.fut.FragmentList;

import android.app.AlertDialog;
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

import com.example.fut.Adaptadores.JuizAdapter;
import com.example.fut.Banco.JuizDao;
import com.example.fut.Banco.Juiz_Class;
import com.example.fut.R;

import java.util.ArrayList;
import java.util.List;

public class JuizFragList extends Fragment {
    private ListView listView;
    private JuizDao dao;
    private List<Juiz_Class> juiz_classes;
    private List<Juiz_Class> juiz_classesFiltrados = new ArrayList<>();
    private Button Rank7;
    private Button Rank8;



    public JuizFragList() {
        // Required empty public constructor
    }

    public static JuizFragList newInstance() {
        JuizFragList fragment = new JuizFragList();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_juiz_frag_list, container, false);

        listView = v.findViewById(R.id.ListJuiz);
        dao = new JuizDao(this.getActivity());
        juiz_classes = dao.obterTodos();
        juiz_classesFiltrados.addAll(juiz_classes);
        JuizAdapter adaptador = new JuizAdapter(getActivity(),juiz_classesFiltrados);
        listView.setAdapter(adaptador);
        Rank7 = v.findViewById(R.id.Rank7);
        Rank8 = v.findViewById(R.id.Rank8);
      Rank7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efeitolike();
           }
        });
       Rank8.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                efeitodeslike();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Juiz_Class jui = juiz_classes.get(i);



                AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity());
                alerta.setIcon(R.drawable.apito);
                alerta.setPositiveButton("GOSTEI!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "CURTIU", Toast.LENGTH_SHORT).show();
                        dao.like(jui);
                        juiz_classes = dao.obterTodos();
                        juiz_classesFiltrados.clear();
                        juiz_classesFiltrados.addAll(juiz_classes);
                        listView.invalidateViews();
                    }
                });
                alerta.setNegativeButton("NÃO GOSTEI!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "DESCURTIU", Toast.LENGTH_SHORT).show();
                        dao.Deslike(jui);
                        juiz_classes = dao.obterTodos();
                        juiz_classesFiltrados.clear();
                        juiz_classesFiltrados.addAll(juiz_classes);
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
        juiz_classes = dao.obterTodos1();
        JuizAdapter adaptador = new JuizAdapter(getActivity(),juiz_classesFiltrados);
        listView.setAdapter(adaptador);
        juiz_classesFiltrados.clear();
        juiz_classesFiltrados.addAll(juiz_classes);
        listView.invalidateViews();
    }

   public void efeitodeslike (){
       juiz_classes = dao.obterTodos2();
       JuizAdapter adaptador = new JuizAdapter(getActivity(),juiz_classesFiltrados);
       listView.setAdapter(adaptador);
        juiz_classesFiltrados.clear();
        juiz_classesFiltrados.addAll(juiz_classes);
        listView.invalidateViews();

    }

}
