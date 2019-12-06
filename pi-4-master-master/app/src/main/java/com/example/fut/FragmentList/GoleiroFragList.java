package com.example.fut.FragmentList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fut.Banco.ContratanteDao;
import com.example.fut.Banco.GandulaDao;
import com.example.fut.Banco.GoleiroDao;
import com.example.fut.Banco.Goleiro_class;
import com.example.fut.Adaptadores.GoleiroAdapter;
import com.example.fut.Banco.JuizDao;
import com.example.fut.Banco.LinhaDao;
import com.example.fut.Principal.MainActivity;
import com.example.fut.R;

import java.util.ArrayList;
import java.util.List;

public class GoleiroFragList extends Fragment {
    private ListView listView;
    private GoleiroDao dao;
    private LinhaDao dao1;
    private GandulaDao dao2;
    private JuizDao dao3;
    private ContratanteDao dao4;
    private Button Rank1;
    private Button Rank2;
    private TextView rankgol;
    private List<Goleiro_class> goleiroClasses;
    private List<Goleiro_class> goleiroClassesFiltrados = new ArrayList<>();


    public GoleiroFragList() {
        // Required empty public constructor
    }


    public static GoleiroFragList newInstance() {
        GoleiroFragList fragment = new GoleiroFragList();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_goleiro_frag_list, container, false);




        listView = v.findViewById(R.id.ListGoleiros);
        Rank1 = v.findViewById(R.id.Rank1);
        Rank2 = v.findViewById(R.id.Rank2);
        rankgol = v.findViewById(R.id.rankgol);
        dao = new GoleiroDao(getActivity());
        dao1 = new LinhaDao(getActivity());
        dao2 = new GandulaDao(getActivity());
        dao3 = new JuizDao(getActivity());
        dao4 = new ContratanteDao(getActivity());
        goleiroClasses = dao.obterTodos();
        goleiroClassesFiltrados.addAll(goleiroClasses);

        //ArrayAdapter<Goleiro_class> adaptador = new ArrayAdapter<Goleiro_class>(this.getActivity(),android.R.layout.simple_list_item_1,goleiroClasses);
        GoleiroAdapter adaptador = new GoleiroAdapter(getActivity(),goleiroClassesFiltrados);
        listView.setAdapter(adaptador);

       Rank1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efeitolike();
            }
        });
        Rank2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efeitodeslike();
            }
        });

        rankgol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                final Goleiro_class gc = goleiroClasses.get(i);



                AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity());
                alerta.setIcon(R.drawable.goleiro);
                alerta.setTitle("O QUE ACHOU DESSE GOLEIRO?");
                alerta.setPositiveButton("GOSTEI!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "CURTIU", Toast.LENGTH_SHORT).show();
                        dao.like(gc);
                        goleiroClasses = dao.obterTodos();
                        goleiroClassesFiltrados.clear();
                        goleiroClassesFiltrados.addAll(goleiroClasses);
                        listView.invalidateViews();
                    }
                });
                alerta.setNegativeButton("NÃO GOSTEI!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "DESCURTIU", Toast.LENGTH_SHORT).show();
                        dao.Deslike(gc);
                        goleiroClasses = dao.obterTodos();
                        goleiroClassesFiltrados.clear();
                        goleiroClassesFiltrados.addAll(goleiroClasses);
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



        //public void like(View view1){

        //}
        return v;


    }
    public void efeitolike (){
        goleiroClasses = dao.obterTodos1();
        GoleiroAdapter adaptador = new GoleiroAdapter(getActivity(),goleiroClassesFiltrados);
       listView.setAdapter(adaptador);
        goleiroClassesFiltrados.clear();
        goleiroClassesFiltrados.addAll(goleiroClasses);
       listView.invalidateViews();

   }

    public void efeitodeslike (){
        goleiroClasses = dao.obterTodos2();
        GoleiroAdapter adaptador = new GoleiroAdapter(getActivity(),goleiroClassesFiltrados);
        listView.setAdapter(adaptador);
        goleiroClassesFiltrados.clear();
        goleiroClassesFiltrados.addAll(goleiroClasses);
        listView.invalidateViews();

    }

    public void delete (){
      dao.Excluirtudogol();
      dao1.Excluirtudolin();
      dao2.Excluirtudogand();
      dao3.Excluirtudojui();
      dao4.Excluirtudocont();
        Intent intent1 = new Intent(getActivity(), MainActivity.class);
        startActivity(intent1);
    }


}