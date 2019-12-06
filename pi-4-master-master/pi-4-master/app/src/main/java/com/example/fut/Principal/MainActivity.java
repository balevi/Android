package com.example.fut.Principal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.fut.Banco.ContratanteClass;
import com.example.fut.Banco.ContratanteDao;
import com.example.fut.Banco.GandulaDao;
import com.example.fut.Banco.Gandula_Class;
import com.example.fut.Banco.GoleiroDao;
import com.example.fut.Banco.JuizDao;
import com.example.fut.Banco.Juiz_Class;
import com.example.fut.Banco.LinhaDao;
import com.example.fut.Banco.Linha_class;
import com.example.fut.Banco.Goleiro_class;
import com.example.fut.R;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Serializable {
    TextView txtRegist;
    Button btnEntra;
    private GoleiroDao dao;
    private GandulaDao dao1;
    private JuizDao dao2;
    private LinhaDao dao3;
    private ContratanteDao dao4;
    private List<Goleiro_class> goleiroClasses;

    //private PrincipalCont princ;
    public EditText txtLogin;
    public EditText txtSenha;
    //public int idpass;
    //private ListView listView;
   // private List<Goleiro_class> goleiroClassesFiltrados = new ArrayList<>();


    public MainActivity (){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        txtRegist = (TextView) findViewById(R.id.txtRegist);
        btnEntra = (Button) findViewById(R.id.btnEntra);
        dao = new GoleiroDao(MainActivity.this);
        dao1 = new GandulaDao(MainActivity.this);
        dao2 = new JuizDao(MainActivity.this);
        dao3 = new LinhaDao(MainActivity.this);
        dao4 = new ContratanteDao(MainActivity.this);
        //goleiroClasses = dao.obterTodos();
        //goleiroClassesFiltrados.addAll(goleiroClasses);

        //princ = new PrincipalCont();
        //*************************************************

        btnEntra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickentra();
            }
        });


        txtRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regist();
            }
        });
    }


    public void clickentra (){

        String name = txtLogin.getText().toString();
        String password = txtSenha.getText().toString();
        int id = checkUser(new Goleiro_class(name,password));
        int id1 = checkUser1(new Gandula_Class(name,password));
        int id2 = checkUser2(new Juiz_Class(name,password));
        int id3 = checkUser3(new Linha_class(name,password));
        int id4 = checkUser4(new ContratanteClass(name,password));


       if (id == -1 && id1 == -1 && id2 == -1 && id3 == -1&& id4 == -1) {
           Toast.makeText(MainActivity.this, "Usuário Não Cadastrado !", Toast.LENGTH_LONG).show();
       }else {
           Toast.makeText(MainActivity.this, "Logando !", Toast.LENGTH_LONG).show();
           final Goleiro_class gc = new Goleiro_class(id);
           final Linha_class lc = new Linha_class(id3);
           final Gandula_Class gac = new Gandula_Class(id1);
           final Juiz_Class jui = new Juiz_Class(id2);
           final ContratanteClass cont = new ContratanteClass(id4);
           Intent intent = new Intent(MainActivity.this, PrincipalCont.class);
           if (id != -1) {
               intent.putExtra("goleiro", gc);
           }
           else if (id3 != -1) {
               intent.putExtra("linha", lc);
           } else if (id1 != -1) {
               intent.putExtra("gandula", gac);
           }else if (id2 != -1) {
               intent.putExtra("juiz", jui);
           }
           else if (id4 != -1) {
               intent.putExtra("contratante",cont);
           }

           startActivity(intent);
            //String man = "homem maluco";
           //dao.Excluir(2);
           //dao.Excluir(3);
           //dao.Excluir(4);
           //dao.Excluir(22);
            //MainActivity man = new MainActivity();
            //man.setIdpass(id);
           //princ.pegaid(man);
           //************************************insert goleiro **********************************************************
           dao.inserir(new Goleiro_class("levi1","123215","Douglas Friedrich","27/04/1990","1.95","80","Pituba","(71)81351360",67,2));
           dao.inserir(new Goleiro_class("levi2","124512","Julian Viáfara","15/07/1988","1.88","77","Brotas","(71)88461360",25,8));
           dao.inserir(new Goleiro_class("levi3","125123","Cláudio Taffarel","03/05/1979","1.83","85","Cabula","(65)328861360",10,5));
           dao.inserir(new Goleiro_class("levi4","126475","Alisson Becker","17/04/1993","1.88","79","Paripe","(92)773561360",70,7));
           dao.inserir(new Goleiro_class("levi5","127742","Alex Muralha","10/03/1992","1.90","85","São Marcos","(61)993561360",31,4));
            //***************************************** insert gandula***********************************************************
           dao1.inserir4(new Gandula_Class("levi6","123412","Italo Hohenfeld","22/06/1997","Cabula","(71)81351360",37,11));
           dao1.inserir4(new Gandula_Class("levi7","123412","João Caser","12/08/1993","Federação","(71)88461360",45,22));
           dao1.inserir4(new Gandula_Class("levi8","123247","Diego Nascimento","30/08/1998","Paripe","(65)328861360",50,15));
           dao1.inserir4(new Gandula_Class("levi9","123532","Douglas Onofre","04/04/1994","Lapa","(92)773561360",52,7));
           dao1.inserir4(new Gandula_Class("levi10","123425","Juan da Silva","11/07/1995","Barra","(61)993561360",31,4));
           //***************************************** insert juiz***********************************************************
           dao2.inserir3(new Juiz_Class("levi11","123412","Anderson Daronco","29/01/1985","Matatu","(71)81351360",37,11));
           dao2.inserir3(new Juiz_Class("levi12","123241","Luiz Flávio de Oliveira","17/03/1982","Comercio","(71)88461360",25,32));
           dao2.inserir3(new Juiz_Class("levi13","123521","Raphael Claus","27/04/1981","Stella Maris","(65)328861360",57,20));
           dao2.inserir3(new Juiz_Class("levi14","123963","Dewson freitas","27/04/1988","Abrantes","(92)773561360",12,77));
           dao2.inserir3(new Juiz_Class("levi14","123854","Ricardo Marques","27/04/1987","Pelourinho","(61)993561360",31,24));
           //***************************************** insert linha ***********************************************************
           dao3.inserir2(new Linha_class("levi16","123512","Gabigol Barbosa","22/05/1993","1.85","80","Amaralina","Atacante","(71)81351360",97,3));
           dao3.inserir2(new Linha_class("levi17","123123","Cristiano Ronaldo","01/04/1990","1.88","77","Pau-Miúdo","Meio-campo","(71)88461360",77,17));
           dao3.inserir2(new Linha_class("levi18","123251","Nino Paraiba","13/12/1988","1.63","65","Caixa D'Agua","Lateral","(65)328861360",88,5));
           dao3.inserir2(new Linha_class("levi19","125243","Pepe Ferreira","07/04/1991","1.92","89","São Caetano","Zaqueiro","(92)773561360",72,50));
           dao3.inserir2(new Linha_class("levi20","123521","Zlatan Ibrahimovic","15/09/1989","1.90","87","Nazaré","Atacante","(61)993561360",94,0));
       }

    }

    public void regist(){
        Intent intent = new Intent (MainActivity.this, TelaCadrast.class);
        startActivity(intent);
    }


    private int checkUser(Goleiro_class us)

    {
        return dao.checkUser(us);
    }

    private int checkUser1(Gandula_Class us1)
    {
        return dao1.checkUser1(us1);
    }

    private int checkUser2(Juiz_Class us2) {
        return dao2.checkUser2(us2);
    }

    private int checkUser3(Linha_class us3)
    {

        return dao3.checkUser3(us3);
    }

    private int checkUser4(ContratanteClass us4)
    {

        return dao4.checkUser4(us4);
    }

    //public void delete(){

      //  id = checkUser(new Goleiro_class(name,password));

       // dao.Excluir(id);

    //}


}
