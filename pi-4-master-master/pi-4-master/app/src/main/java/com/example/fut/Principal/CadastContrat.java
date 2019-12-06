package com.example.fut.Principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fut.Banco.ContratanteClass;
import com.example.fut.Banco.ContratanteDao;
import com.example.fut.R;

public class CadastContrat extends AppCompatActivity {
    private EditText txtLoginCont;
    private EditText txtSenhaCont;
    private Button btnCont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadast_contrat);
        txtLoginCont = findViewById(R.id.txtLoginCont);
        txtSenhaCont = findViewById(R.id.txtSenhaCont);
        btnCont = findViewById(R.id.btnCont);
        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtLoginCont.getText().toString().isEmpty()||txtSenhaCont.getText().toString().isEmpty()){
                    Toast.makeText(CadastContrat.this,"PREENCHA TODOS OS CAMPOS !",Toast.LENGTH_LONG).show();
                }else{

                    ContratanteClass c = new ContratanteClass();
                    c.setTxtLoginCont(txtLoginCont.getText().toString());
                    c.setTxtSenhaCont(txtSenhaCont.getText().toString());
                    ContratanteDao cont = new ContratanteDao(CadastContrat.this);
                    cont.inserir(c);
                    Toast.makeText(CadastContrat.this,"Contratante Cadastrado Com Sucesso!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent (CadastContrat.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

            }
    }

