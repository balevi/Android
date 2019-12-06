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

import com.example.fut.Banco.GoleiroDao;
import com.example.fut.Banco.Goleiro_class;
import com.example.fut.Principal.MainActivity;
import com.example.fut.R;

public class goleiro extends Fragment {
    Button btnsalvgoleiro;
    private EditText txtLoginGol;
    private EditText txtSenhaGol;
    private EditText txtNomeGol;
    private EditText txtBairroGol;
    private EditText txtTelGol;
    private EditText DataJogo;
    private EditText HoraJogo;
    private TextView LikeGol;
    private Spinner spin;



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
         txtBairroGol = v.findViewById(R.id.txtBairroGol);
         txtTelGol = v.findViewById(R.id.txtTelGol);
         DataJogo = v.findViewById(R.id.DataJogo);
         HoraJogo = v.findViewById(R.id.HoraJogo);
         LikeGol = v.findViewById(R.id.LikeGol);
         spin = (Spinner) v.findViewById(R.id.spin);
        //***********************************************************************************************
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this.getActivity(),R.array.precisa,android.R.layout.simple_spinner_item);
        spin.setAdapter(adapter);



        //dao = new GoleiroDao(this.getActivity());
         //************************************************************************************
         btnsalvgoleiro.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if(txtLoginGol.getText().toString().isEmpty()||txtSenhaGol.getText().toString().isEmpty()||txtNomeGol.getText().toString().isEmpty()||txtBairroGol.getText().toString().isEmpty()||txtTelGol.getText().toString().isEmpty()){
                     Toast.makeText(getActivity(),"PREENCHA TODOS OS CAMPOS !",Toast.LENGTH_LONG).show();
                 }else if(txtLoginGol.getText().length()<5){
                     Toast.makeText(getActivity(),"LOGIN NO MÍNIMO 6 DIGITOS!",Toast.LENGTH_LONG).show();
                 }


                 else{
                     Goleiro_class g = new Goleiro_class();

                 g.setTxtLoginGol(txtLoginGol.getText().toString());
                 g.setTxtSenhaGol(txtSenhaGol.getText().toString());
                 g.setTxtNomeGol(txtNomeGol.getText().toString());
                 g.setTxtPrecisa(spin.getSelectedItem().toString());
                 g.setTxtBairroGol(txtBairroGol.getText().toString());
                 g.setTxtTelGol(txtTelGol.getText().toString());
                 g.setDataJogo(DataJogo.getText().toString());
                 g.setHoraJogo(HoraJogo.getText().toString());
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
