package com.example.fut.FragmentList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fut.Banco.GandulaDao;
import com.example.fut.Banco.Gandula_Class;
import com.example.fut.Adaptadores.GandulaAdapter;
import com.example.fut.R;

import java.util.ArrayList;
import java.util.List;


public class GandulaFragList extends Fragment {
    private ListView listView;
    private GandulaDao dao;
    private List<Gandula_Class> gandulaClasses;
    private List<Gandula_Class> gandulaClassesFiltrados = new ArrayList<>();
    private Button Rank5;
    private Button Rank6;





    public GandulaFragList() {
        // Required empty public constructor
    }


    public static GandulaFragList newInstance() {
        GandulaFragList fragment = new GandulaFragList();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gandula_frag_list, container, false);

        listView = v.findViewById(R.id.ListGandula);
        Rank5 = v.findViewById(R.id.Rank5);
        Rank6 = v.findViewById(R.id.Rank6);
        dao = new GandulaDao(this.getActivity());
        gandulaClasses = dao.obterTodos();
        gandulaClassesFiltrados.addAll(gandulaClasses);
        GandulaAdapter adaptador = new GandulaAdapter(getActivity(),gandulaClassesFiltrados);
        listView.setAdapter(adaptador);

        Rank5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efeitolike();
            }
        });
        Rank6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efeitodeslike();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Gandula_Class gan = gandulaClasses.get(i);



                AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity());
                alerta.setIcon(R.drawable.gandula);
                alerta.setTitle("O QUE ACHOU DESSE GANDULA?");
                alerta.setPositiveButton("GOSTEI!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "CURTIU", Toast.LENGTH_SHORT).show();
                        dao.like(gan);
                        gandulaClasses = dao.obterTodos();
                        gandulaClassesFiltrados.clear();
                        gandulaClassesFiltrados.addAll(gandulaClasses);
                        listView.invalidateViews();
                    }
                });
                alerta.setNegativeButton("NÃO GOSTEI!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "DESCURTIU", Toast.LENGTH_SHORT).show();
                        dao.Deslike(gan);
                        gandulaClasses = dao.obterTodos();
                        gandulaClassesFiltrados.clear();
                        gandulaClassesFiltrados.addAll(gandulaClasses);
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
        gandulaClasses = dao.obterTodos1();
        GandulaAdapter adaptador = new GandulaAdapter(getActivity(),gandulaClassesFiltrados);
        listView.setAdapter(adaptador);
        gandulaClassesFiltrados.clear();
        gandulaClassesFiltrados.addAll(gandulaClasses);
        listView.invalidateViews();

    }

    public void efeitodeslike (){
        gandulaClasses = dao.obterTodos2();
        GandulaAdapter adaptador = new GandulaAdapter(getActivity(),gandulaClassesFiltrados);
        listView.setAdapter(adaptador);
        gandulaClassesFiltrados.clear();
        gandulaClassesFiltrados.addAll(gandulaClasses);
        listView.invalidateViews();

    }

}
