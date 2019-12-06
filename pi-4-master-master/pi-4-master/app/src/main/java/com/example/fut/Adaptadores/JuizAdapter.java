package com.example.fut.Adaptadores;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fut.Banco.Gandula_Class;
import com.example.fut.Banco.Juiz_Class;
import com.example.fut.R;

import java.util.List;

public class JuizAdapter extends BaseAdapter {

    private List<Juiz_Class> juiz_classes;
    private Activity activity;

    public JuizAdapter(Activity activity, List<Juiz_Class> juiz_classes) {
        this.activity = activity;
        this.juiz_classes = juiz_classes;
    }

    @Override
    public int getCount() {
        return juiz_classes.size();
    }

    @Override
    public Object getItem(int position) {
        return juiz_classes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return juiz_classes.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View vw = activity.getLayoutInflater().inflate(R.layout.itemjuiz, viewGroup, false);
        TextView nome = vw.findViewById(R.id.txtNomeJuiz1);
        TextView idade = vw.findViewById(R.id.txtIdadeJuiz1);
        TextView bairro = vw.findViewById(R.id.txtBairroJuiz1);
        TextView telefone = vw.findViewById(R.id.txtTelJuiz1);
        TextView likegand = vw.findViewById(R.id.LikeJuiz1);
        TextView Deslikegand = vw.findViewById(R.id.DeslikeJuiz1);


        Juiz_Class jui = juiz_classes.get(position);

        nome.setText(jui.getTxtNomeJuiz());
        idade.setText(jui.getTxtIdadeJuiz());
        bairro.setText(jui.getBairroJuiz());
        telefone.setText(jui.getTxtTelJuiz());
        likegand.setText(String.valueOf(jui.getLikeJuiz()));
        Deslikegand.setText(String.valueOf(jui.getDeslikeJuiz()));


        return vw;

    }
}
