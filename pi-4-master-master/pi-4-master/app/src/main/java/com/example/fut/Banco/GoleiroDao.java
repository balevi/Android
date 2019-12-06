package com.example.fut.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GoleiroDao extends SQLiteOpenHelper {

    public GoleiroDao (Context context){
        super(context, "banco.db1", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
       String sql = "create table goleirotab(id integer primary key autoincrement, txtLoginGol varchar (50),txtSenhaGol varchar(50),txtNomeGol varchar(50), txtIdadeGol varchar(50),txtAlturaGol varchar (50), txtPesoGol varchar (50),txtBairroGol varchar(50),txtTelGol varchar(12),LikeGol integer(3),DeslikeGol integer(3))";

        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void inserir(Goleiro_class goleiroClass){
        ContentValues values = new ContentValues();
        values.put("txtLoginGol",goleiroClass.getTxtLoginGol());
        values.put("txtSenhaGol",goleiroClass.getTxtSenhaGol());
        values.put("txtNomeGol",goleiroClass.getTxtNomeGol());
        values.put("txtIdadeGol",goleiroClass.getTxtIdadeGol());
        values.put("txtAlturaGol",goleiroClass.getTxtAlturaGol());
        values.put("txtPesoGol",goleiroClass.getTxtPesoGol());
        values.put("txtBairroGol",goleiroClass.getTxtBairroGol());
        values.put("txtTelGol",goleiroClass.getTxtTelGol());
        values.put("LikeGol",goleiroClass.getLikeGol());
        values.put("DeslikeGol",goleiroClass.getDeslikeGol());
         getWritableDatabase().insert("goleirotab", null, values);
    }



    public List<Goleiro_class>obterTodos(){
        List<Goleiro_class> goleiroClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("goleirotab", new String[]{"id","txtLoginGol","txtSenhaGol","txtNomeGol","txtIdadeGol","txtAlturaGol","txtPesoGol","txtBairroGol","txtTelGol","LikeGol","DeslikeGol"},null,null,null,null,null);
        while (cursor.moveToNext()){
            Goleiro_class g = new Goleiro_class();
            g.setId(cursor.getInt(0));
            g.setTxtLoginGol(cursor.getString(1));
            g.setTxtSenhaGol(cursor.getString(2));
            g.setTxtNomeGol(cursor.getString(3));
            g.setTxtIdadeGol(cursor.getString(4));
            g.setTxtAlturaGol(cursor.getString(5));
            g.setTxtPesoGol(cursor.getString(6));
            g.setTxtBairroGol(cursor.getString(7));
            g.setTxtTelGol(cursor.getString(8));
            g.setLikeGol(cursor.getInt(9));
            g.setDeslikeGol(cursor.getInt(10));
            goleiroClasses.add(g);
        }
        return goleiroClasses;
    }

    public List<Goleiro_class>obterTodos1(){
        List<Goleiro_class> goleiroClasses = new ArrayList<>();

        Cursor cursor = getWritableDatabase().query("goleirotab", new String[]{"id","txtLoginGol","txtSenhaGol","txtNomeGol","txtIdadeGol","txtAlturaGol","txtPesoGol","txtBairroGol","txtTelGol","LikeGol","DeslikeGol"},null,null,null,null,"LikeGol desc");
        while (cursor.moveToNext()){
            Goleiro_class g = new Goleiro_class();
            g.setId(cursor.getInt(0));
            g.setTxtLoginGol(cursor.getString(1));
            g.setTxtSenhaGol(cursor.getString(2));
            g.setTxtNomeGol(cursor.getString(3));
            g.setTxtIdadeGol(cursor.getString(4));
            g.setTxtAlturaGol(cursor.getString(5));
            g.setTxtPesoGol(cursor.getString(6));
            g.setTxtBairroGol(cursor.getString(7));
            g.setTxtTelGol(cursor.getString(8));
            g.setLikeGol(cursor.getInt(9));
            g.setDeslikeGol(cursor.getInt(10));
            goleiroClasses.add(g);
        }
        return goleiroClasses;
    }

    public List<Goleiro_class>obterTodos2(){
        List<Goleiro_class> goleiroClasses = new ArrayList<>();

        Cursor cursor = getWritableDatabase().query("goleirotab", new String[]{"id","txtLoginGol","txtSenhaGol","txtNomeGol","txtIdadeGol","txtAlturaGol","txtPesoGol","txtBairroGol","txtTelGol","LikeGol","DeslikeGol"},null,null,null,null,"DeslikeGol desc");
        while (cursor.moveToNext()){
            Goleiro_class g = new Goleiro_class();
            g.setId(cursor.getInt(0));
            g.setTxtLoginGol(cursor.getString(1));
            g.setTxtSenhaGol(cursor.getString(2));
            g.setTxtNomeGol(cursor.getString(3));
            g.setTxtIdadeGol(cursor.getString(4));
            g.setTxtAlturaGol(cursor.getString(5));
            g.setTxtPesoGol(cursor.getString(6));
            g.setTxtBairroGol(cursor.getString(7));
            g.setTxtTelGol(cursor.getString(8));
            g.setLikeGol(cursor.getInt(9));
            g.setDeslikeGol(cursor.getInt(10));
            goleiroClasses.add(g);
        }
        return goleiroClasses;
    }

        public int checkUser (Goleiro_class us){
        int id = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM goleirotab WHERE txtLoginGol = ? AND txtSenhaGol = ?", new String[]{us.getTxtLoginGol(),us.getTxtSenhaGol()});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            id = cursor.getInt(0);
            cursor.close();
        }
        return id;
    }

        public void like(Goleiro_class gol){
            Integer cont = 1;
            ContentValues values = new ContentValues();
            values.put("LikeGol",gol.getLikeGol()+cont);
            getWritableDatabase().update("goleirotab",values, "id = ?", new String[]{gol.getId().toString()});
        }

    public void Deslike(Goleiro_class gol){
        Integer cont = 1;
        ContentValues values = new ContentValues();
        values.put("DeslikeGol",gol.getDeslikeGol()+cont);
        getWritableDatabase().update("goleirotab",values, "id = ?", new String[]{gol.getId().toString()});
    }
    public void Excluir(Goleiro_class gol){
        getWritableDatabase().delete("goleirotab", "id = ?", new String[]{gol.getId().toString()});
    }


}