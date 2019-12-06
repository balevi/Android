package com.example.fut.Adaptadores;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fut.Banco.Gandula_Class;
import com.example.fut.R;

import java.util.List;

public class GandulaAdapter extends BaseAdapter {

    private List<Gandula_Class> gandulaClasses;
    private Activity activity;

    public GandulaAdapter(Activity activity, List<Gandula_Class> gandulaClasses) {
        this.activity = activity;
        this.gandulaClasses = gandulaClasses;
    }

    @Override
    public int getCount() {
        return gandulaClasses.size();
    }

    @Override
    public Object getItem(int position) {
        return  gandulaClasses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  gandulaClasses.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View vw = activity.getLayoutInflater().inflate(R.layout.itemgand, viewGroup, false);
        TextView nome = vw.findViewById(R.id.txtNomeGand1);
        TextView idade = vw.findViewById(R.id.txtIdadeGand1);
        TextView bairro = vw.findViewById(R.id.txtBairroGand1);
        TextView telefone = vw.findViewById(R.id.txtTelGand1);
        TextView likegand = vw.findViewById(R.id.LikeGand1);
        TextView Deslikegand = vw.findViewById(R.id.DeslikeGand1);
        //Button botlike = vw.findViewById(R.id.botlike1);


        Gandula_Class gan = gandulaClasses.get(position);

        nome.setText(gan.getTxtNomeGand());
        idade.setText(gan.getTxtIdadeGand());
        bairro.setText(gan.getTxtBairroGand());
        telefone.setText(gan.getTxtTelGand());
        likegand.setText(String.valueOf(gan.getLikeGand()));
        Deslikegand.setText(String.valueOf(gan.getDeslikeGand()));


        return vw;

    }


}
