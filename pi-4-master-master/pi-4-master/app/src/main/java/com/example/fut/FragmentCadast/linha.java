package com.example.fut.FragmentCadast;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fut.Banco.LinhaDao;
import com.example.fut.Banco.Linha_class;
import com.example.fut.Principal.MainActivity;
import com.example.fut.R;

public class linha extends Fragment {

    private EditText txtLoginLinha;
    private EditText txtSenhaLinha;
    private EditText txtNomeLinha;
    private EditText txtIdadeLinha;
    private EditText txtAlturaLinha;
    private EditText txtPesoLinha;
    private EditText txtBairroLinha;
    private EditText txtTelLinha;
    private TextView Likelinha;

    private Spinner spinLinha;
    Button btnsalvlinha;

    public linha() {

    }

    public static linha newInstance() {
        linha fragment = new linha();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View v =inflater.inflate(R.layout.fragment_linha, container, false);
        //****************************************************************************
        txtLoginLinha = v.findViewById(R.id.txtLoginLinha);
        txtSenhaLinha = v.findViewById(R.id.txtSenhaLinha);
        txtNomeLinha = v.findViewById(R.id.txtNomeLinha);
        txtIdadeLinha = v.findViewById(R.id.txtIdadeLinha);
        txtAlturaLinha = v.findViewById(R.id.txtAlturaLinha);
        txtPesoLinha = v.findViewById(R.id.txtPesoLinha);
        txtBairroLinha = v.findViewById(R.id.txtBairroLinha);
        txtTelLinha = v.findViewById(R.id.txtTelLinha);
        btnsalvlinha = v.findViewById(R.id.btnsalvlinha);
        spinLinha = (Spinner) v.findViewById(R.id.spinLinha);
        Likelinha = v.findViewById(R.id.Likelinha);
         //***********************************************************************************************
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getActivity(),R.array.posicao,android.R.layout.simple_spinner_item);
        spinLinha.setAdapter(adapter);

        btnsalvlinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtLoginLinha.getText().toString().isEmpty() || txtSenhaLinha.getText().toString().isEmpty() || txtNomeLinha.getText().toString().isEmpty() | txtIdadeLinha.getText().toString().isEmpty() || txtAlturaLinha.getText().toString().isEmpty() || txtPesoLinha.getText().toString().isEmpty() || txtBairroLinha.getText().toString().isEmpty()||spinLinha.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "PREENCHA TODOS OS CAMPOS !", Toast.LENGTH_LONG).show();
                } else {
                    Linha_class l = new Linha_class();
                    l.setTxtLoginLinha(txtLoginLinha.getText().toString());
                    l.setTxtSenhaLinha(txtSenhaLinha.getText().toString());
                    l.setTxtNomeLinha(txtNomeLinha.getText().toString());
                    l.setTxtIdadeLinha(txtIdadeLinha.getText().toString());
                    l.setTxtAlturaLinha(txtAlturaLinha.getText().toString());
                    l.setTxtPesoLinha(txtPesoLinha.getText().toString());
                    l.setTxtBairroLinha(txtBairroLinha.getText().toString());
                    l.setSpinLinha(spinLinha.getSelectedItem().toString());
                    l.setTxtTelLinha(txtTelLinha.getText().toString());
                    Integer numeroConvertido = Integer.parseInt(Likelinha.getText().toString());
                    l.setLikeLinha(numeroConvertido);
                    l.setDeslikeLinha(numeroConvertido);
                    LinhaDao lin = new LinhaDao(getActivity());
                    lin.inserir2(l);
                    Toast.makeText(getActivity(), "Jogador Cadastrado Com Sucesso!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        return v;
    }


}
