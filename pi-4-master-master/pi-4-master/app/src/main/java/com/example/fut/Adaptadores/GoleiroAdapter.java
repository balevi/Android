package com.example.fut.Adaptadores;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fut.Banco.Goleiro_class;
import com.example.fut.R;

import java.util.List;

public class GoleiroAdapter extends BaseAdapter {
    private List<Goleiro_class> goleiroClasses;
    private Activity activity;

    public GoleiroAdapter(Activity activity, List<Goleiro_class> goleiroClasses) {
        this.activity = activity;
        this.goleiroClasses = goleiroClasses;
    }

    @Override
    public int getCount() {
        return goleiroClasses.size();
    }

    @Override
    public Object getItem(int position) {
        return goleiroClasses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return goleiroClasses.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View vw = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);
        TextView nome = vw.findViewById(R.id.txtNomeGol1);
        TextView idade = vw.findViewById(R.id.txtIdadeGol1);
        TextView altura = vw.findViewById(R.id.txtAlturaGol1);
        TextView peso = vw.findViewById(R.id.txtPesoGol1);
        TextView bairro = vw.findViewById(R.id.txtBairroGol1);
        TextView telefone = vw.findViewById(R.id.txtTelGol1);
        TextView likegol = vw.findViewById(R.id.LikeGol1);
        TextView Deslikegol = vw.findViewById(R.id.DeslikeGol1);
        //Button botlike = vw.findViewById(R.id.botlike1);


        Goleiro_class g = goleiroClasses.get(position);

        nome.setText(g.getTxtNomeGol());
        idade.setText(g.getTxtIdadeGol());
        altura.setText(g.getTxtAlturaGol());
        peso.setText(g.getTxtPesoGol());
        bairro.setText(g.getTxtBairroGol());
        telefone.setText(g.getTxtTelGol());
        likegol.setText(String.valueOf(g.getLikeGol()));
        Deslikegol.setText(String.valueOf(g.getDeslikeGol()));


        return vw;

    }

}
