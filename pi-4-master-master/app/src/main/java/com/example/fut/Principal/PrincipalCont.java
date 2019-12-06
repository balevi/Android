package com.example.fut.Principal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fut.Banco.ContratanteClass;
import com.example.fut.Banco.ContratanteDao;
import com.example.fut.Banco.GandulaDao;
import com.example.fut.Banco.Gandula_Class;
import com.example.fut.Banco.GoleiroDao;
import com.example.fut.Banco.Goleiro_class;
import com.example.fut.Banco.JuizDao;
import com.example.fut.Banco.Juiz_Class;
import com.example.fut.Banco.LinhaDao;
import com.example.fut.Banco.Linha_class;
import com.example.fut.R;

public class PrincipalCont extends AppCompatActivity {
    Button btnMerc;
    Button btnExcluirPerfil;
    TextView txtPerfil1;

    private GoleiroDao dao;
    private Goleiro_class goleiro = null;
    private Linha_class linha = null;
    private Gandula_Class gandula = null;
    private Juiz_Class juiz = null;
    private ContratanteClass cont = null;

    private GandulaDao dao1;
    private JuizDao dao2;
    private LinhaDao dao3;
    private ContratanteDao dao4;

    public PrincipalCont (){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_cont);
        btnMerc = findViewById(R.id.btnMerc);
        txtPerfil1 = findViewById(R.id.txtPerfil1);
        btnExcluirPerfil = findViewById(R.id.btnExcluirPerfil);
        dao = new GoleiroDao(PrincipalCont.this);
        dao1 = new GandulaDao(PrincipalCont.this);
        dao2 = new JuizDao(PrincipalCont.this);
        dao3 = new LinhaDao(PrincipalCont.this);
        dao4 = new ContratanteDao(PrincipalCont.this);

        btnMerc.setOnClickListener(mudar);

        btnExcluirPerfil.setOnClickListener(excluirperfil);
        //man = new MainActivity();




    }

    View.OnClickListener mudar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                Intent intent = new Intent(PrincipalCont.this, Inicio1.class);
                startActivity(intent);
        }
    };




        View.OnClickListener excluirperfil = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(PrincipalCont.this);
                alerta.setTitle("DESEJA EXCLUIR SEU PERFIL?");
                //alerta.setMessage("GOSTOU OU NÃO GOSTOU?");
                alerta.setPositiveButton("SIM!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PrincipalCont.this, "PERFIL APAGADO!", Toast.LENGTH_SHORT).show();
                    //man.delete();
                        Intent intent = getIntent();
                        if (intent.hasExtra("goleiro")){
                            goleiro = (Goleiro_class)intent.getSerializableExtra("goleiro");
                            dao.Excluir(goleiro);
                            Intent intent1 = new Intent(PrincipalCont.this, MainActivity.class);
                            startActivity(intent1);


                        }

                        else if (intent.hasExtra("linha")){
                            linha = (Linha_class)intent.getSerializableExtra("linha");
                            dao3.Excluir(linha);
                            Intent intent1 = new Intent(PrincipalCont.this, MainActivity.class);
                            startActivity(intent1);


                        }  else if (intent.hasExtra("gandula")){
                            gandula = (Gandula_Class)intent.getSerializableExtra("gandula");
                            dao1.Excluir(gandula);
                            Intent intent1 = new Intent(PrincipalCont.this, MainActivity.class);
                            startActivity(intent1);


                        }else if (intent.hasExtra("juiz")){
                            juiz = (Juiz_Class)intent.getSerializableExtra("juiz");
                            dao2.Excluir(juiz);
                            Intent intent1 = new Intent(PrincipalCont.this, MainActivity.class);
                            startActivity(intent1);


                        }else if (intent.hasExtra("contratante")){
                            cont = (ContratanteClass)intent.getSerializableExtra("contratante");
                            dao4.Excluir(cont);
                            Intent intent1 = new Intent(PrincipalCont.this, MainActivity.class);
                            startActivity(intent1);

                        }



                    }
                });

                alerta.setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                //AlertDialog alertaDialog = alerta.create();
                alerta.show();
            }
        };




}
