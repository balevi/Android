package com.example.fut.FragmentCadast;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fut.Banco.GoleiroDao;
import com.example.fut.Banco.Goleiro_class;
import com.example.fut.Principal.MainActivity;
import com.example.fut.R;

public class goleiro extends Fragment {
    Button btnsalvgoleiro;
    private EditText txtLoginGol;
    private EditText txtSenhaGol;
    private EditText txtNomeGol;
    private EditText txtIdadeGol;
    private EditText txtAlturaGol;
    private EditText txtPesoGol;
    private EditText txtBairroGol;
    private EditText txtTelGol;
    private TextView LikeGol;



    public goleiro() {
    }
    public static goleiro newInstance() {
        goleiro fragment = new goleiro();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_goleiro, container, false);
         //****************************************************************************
         btnsalvgoleiro = v.findViewById(R.id.btnsalvgoleiro);
         txtLoginGol = v.findViewById(R.id.txtLoginGol);
         txtSenhaGol = v.findViewById(R.id.txtSenhaGol);
         txtNomeGol = v.findViewById(R.id.txtNomeGol);
         txtIdadeGol = v.findViewById(R.id.txtIdadeGol);
         txtAlturaGol = v.findViewById(R.id.txtAlturaGol);
         txtPesoGol = v.findViewById(R.id.txtPesoGol);
         txtBairroGol = v.findViewById(R.id.txtBairroGol);
         txtTelGol = v.findViewById(R.id.txtTelGol);
         LikeGol = v.findViewById(R.id.LikeGol);


         //dao = new GoleiroDao(this.getActivity());
         //************************************************************************************
         btnsalvgoleiro.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if(txtLoginGol.getText().toString().isEmpty()||txtSenhaGol.getText().toString().isEmpty()||txtNomeGol.getText().toString().isEmpty()|txtIdadeGol.getText().toString().isEmpty()||txtAlturaGol.getText().toString().isEmpty()||txtPesoGol.getText().toString().isEmpty()||txtBairroGol.getText().toString().isEmpty()||txtTelGol.getText().toString().isEmpty()){
                     Toast.makeText(getActivity(),"PREENCHA TODOS OS CAMPOS !",Toast.LENGTH_LONG).show();
                 }else{

                 Goleiro_class g = new Goleiro_class();
                 g.setTxtLoginGol(txtLoginGol.getText().toString());
                 g.setTxtSenhaGol(txtSenhaGol.getText().toString());
                 g.setTxtNomeGol(txtNomeGol.getText().toString());
                 g.setTxtIdadeGol(txtIdadeGol.getText().toString());
                 g.setTxtAlturaGol(txtAlturaGol.getText().toString());
                 g.setTxtPesoGol(txtPesoGol.getText().toString());
                 g.setTxtBairroGol(txtBairroGol.getText().toString());
                 g.setTxtTelGol(txtTelGol.getText().toString());
                 Integer numeroConvertido = Integer.parseInt(LikeGol.getText().toString());
                 g.setLikeGol(numeroConvertido);
                 g.setDeslikeGol(numeroConvertido);
                 //long id = dao.inserir(g);
                GoleiroDao gol = new GoleiroDao(getActivity());
                gol.inserir(g);
                 Toast.makeText(getActivity(),"Goleiro Cadastrado Com Sucesso!",Toast.LENGTH_LONG).show();
                 Intent intent = new Intent (getActivity(), MainActivity.class);
                 startActivity(intent);
             }
         }
         }
         );


        return v;

    }

}
