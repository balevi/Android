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

import com.example.fut.Banco.GandulaDao;
import com.example.fut.Banco.Gandula_Class;
import com.example.fut.Principal.MainActivity;
import com.example.fut.R;

public class gandula extends Fragment {

    private EditText txtLoginGand;
    private EditText txtSenhaGand;
    private EditText txtNomeGand;
    private EditText txtIdadeGand;
    private EditText txtBairroGand;
    private EditText txtTelGand;
    private TextView LikeGand;
    Button btnsalvgandula;


    public gandula() {

    }

    public static gandula newInstance() {
        gandula fragment = new gandula();

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_gandula, container, false);

         txtLoginGand = v.findViewById(R.id.txtLoginGand);
         txtSenhaGand = v.findViewById(R.id.txtSenhaGand);
         txtNomeGand = v.findViewById(R.id.txtNomeGand);
         txtIdadeGand = v.findViewById(R.id.txtIdadeGand);
         txtBairroGand = v.findViewById(R.id.txtBairroGand);
         btnsalvgandula = v.findViewById(R.id.btnsalvgandula);
         txtTelGand = v.findViewById(R.id.txtTelGand);
         LikeGand = v.findViewById(R.id.LikeGand);


         btnsalvgandula.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (txtLoginGand.getText().toString().isEmpty() || txtSenhaGand.getText().toString().isEmpty() || txtNomeGand.getText().toString().isEmpty() | txtIdadeGand.getText().toString().isEmpty() || txtBairroGand.getText().toString().isEmpty()) {
                     Toast.makeText(getActivity(), "PREENCHA TODOS OS CAMPOS !", Toast.LENGTH_LONG).show();
                 } else {
                     Gandula_Class gan = new Gandula_Class();
                     gan.setTxtLoginGand(txtLoginGand.getText().toString());
                     gan.setTxtSenhaGand(txtSenhaGand.getText().toString());
                     gan.setTxtNomeGand(txtNomeGand.getText().toString());
                     gan.setTxtIdadeGand(txtIdadeGand.getText().toString());
                     gan.setTxtBairroGand(txtBairroGand.getText().toString());
                     gan.setTxtTelGand(txtTelGand.getText().toString());
                     Integer numeroConvertido = Integer.parseInt(LikeGand.getText().toString());
                     gan.setLikeGand(numeroConvertido);
                     gan.setDeslikeGand(numeroConvertido);
                     GandulaDao gand = new GandulaDao(getActivity());
                     gand.inserir4(gan);
                     Toast.makeText(getActivity(), "Gandula Salvo Com Sucesso!", Toast.LENGTH_LONG).show();
                     Intent intent = new Intent(getActivity(), MainActivity.class);
                     startActivity(intent);
                 }
             }
         });
        return v;
    }


}
