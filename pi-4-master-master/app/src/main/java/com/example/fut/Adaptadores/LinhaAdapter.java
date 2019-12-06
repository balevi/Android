package com.example.fut.Adaptadores;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fut.Banco.Linha_class;
import com.example.fut.R;

import java.util.List;

public class LinhaAdapter extends BaseAdapter {

    private List<Linha_class> linha_classes;
    private Activity activity;

    public LinhaAdapter(Activity activity, List<Linha_class> linha_classes) {
        this.activity = activity;
        this.linha_classes = linha_classes;
    }

    @Override
    public int getCount() {
        return linha_classes.size();
    }

    @Override
    public Object getItem(int position) {
        return linha_classes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return linha_classes.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View vw = activity.getLayoutInflater().inflate(R.layout.itemlinhaa, viewGroup, false);
        TextView nome = vw.findViewById(R.id.txtNomeLinha1);
        TextView idade = vw.findViewById(R.id.txtIdadeLinha1);
        TextView altura = vw.findViewById(R.id.txtAlturaLinha1);
        TextView peso = vw.findViewById(R.id.txtPesoLinha1);
        TextView bairro = vw.findViewById(R.id.txtBairroLinha1);
        TextView telefone = vw.findViewById(R.id.txtTelLinha1);
        TextView Posicao = vw.findViewById(R.id.txtPosLinha1);
        TextView likegol = vw.findViewById(R.id.LikeLinha1);
        TextView Deslikegol = vw.findViewById(R.id.DeslikeLinha1);
        //Button botlike = vw.findViewById(R.id.botlike1);


        Linha_class lin = linha_classes.get(position);

        nome.setText(lin.getTxtNomeLinha());
        idade.setText(lin.getTxtIdadeLinha());
        altura.setText(lin.getTxtAlturaLinha());
        peso.setText(lin.getTxtPesoLinha());
        bairro.setText(lin.getTxtBairroLinha());
        telefone.setText(lin.getTxtTelLinha());
        Posicao.setText(lin.getSpinLinha());
        likegol.setText(String.valueOf(lin.getLikeLinha()));
        Deslikegol.setText(String.valueOf(lin.getDeslikeLinha()));


        return vw;

    }

}
