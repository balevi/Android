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

import com.example.fut.Banco.JuizDao;
import com.example.fut.Banco.Juiz_Class;
import com.example.fut.Principal.MainActivity;
import com.example.fut.R;

public class juiz extends Fragment {
    EditText txtLoginJuiz;
    EditText txtSenhaJuiz;
    EditText txtNomeJuiz;
    EditText txtIdadeJuiz;
    EditText BairroJuiz;
    EditText txtTelJuiz;
    TextView LikeJuiz;


    Button btnsalvjuiz;

    public juiz() {

    }


    public static juiz newInstance() {
        juiz fragment = new juiz();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View v = inflater.inflate(R.layout.fragment_juiz, container, false);
        txtLoginJuiz = v.findViewById(R.id.txtLoginJuiz);
        txtSenhaJuiz = v.findViewById(R.id.txtSenhaJuiz);
        txtNomeJuiz = v.findViewById(R.id.txtNomeJuiz);
        txtIdadeJuiz = v.findViewById(R.id.txtIdadeJuiz);
        BairroJuiz = v.findViewById(R.id.txtBairroJuiz);
        txtTelJuiz = v.findViewById(R.id.txtTelJuiz);
        LikeJuiz = v.findViewById(R.id.LikeJuiz);
        //************************************************************************************************


        btnsalvjuiz = v.findViewById(R.id.btnsalvjuiz);
        btnsalvjuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtLoginJuiz.getText().toString().isEmpty() || txtSenhaJuiz.getText().toString().isEmpty() || txtNomeJuiz.getText().toString().isEmpty() | txtIdadeJuiz.getText().toString().isEmpty()  || BairroJuiz.getText().toString().isEmpty() || txtTelJuiz.toString().isEmpty()) {
                    Toast.makeText(getActivity(), "PREENCHA TODOS OS CAMPOS !", Toast.LENGTH_LONG).show();
                } else {
                    Juiz_Class j = new Juiz_Class();
                    j.setTxtLoginJuiz(txtLoginJuiz.getText().toString());
                    j.setTxtSenhaJuiz(txtSenhaJuiz.getText().toString());
                    j.setTxtNomeJuiz(txtNomeJuiz.getText().toString());
                    j.setTxtIdadeJuiz(txtIdadeJuiz.getText().toString());
                    j.setBairroJuiz(BairroJuiz.getText().toString());
                    j.setTxtTelJuiz(txtTelJuiz.getText().toString());
                    Integer numeroConvertido = Integer.parseInt(LikeJuiz.getText().toString());
                    j.setLikeJuiz(numeroConvertido);
                    j.setDeslikeJuiz(numeroConvertido);
                    JuizDao juiz = new JuizDao(getActivity());
                    juiz.inserir3(j);
                    Toast.makeText(getActivity(), "Juiz Cadastrado Com Sucesso!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        return v;
    }


}
