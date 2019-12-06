package com.example.fut.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class JuizDao extends SQLiteOpenHelper {
    public JuizDao(Context context) {
        super(context,"Banco.db3", null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql2 = "create table juiztab(id integer primary key autoincrement, txtLoginJuiz varchar (50),txtSenhaJuiz varchar(50),txtNomeJuiz varchar(50), txtIdadeJuiz varchar(50),txtBairroJuiz varchar(50),txtTelJuiz varchar(12),LikeJuiz integer (3),DeslikeJuiz integer (3))";

        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserir3(Juiz_Class juiz_class) {
        ContentValues values2 = new ContentValues();
        values2.put("txtLoginJuiz", juiz_class.getTxtLoginJuiz());
        values2.put("txtSenhaJuiz", juiz_class.getTxtSenhaJuiz());
        values2.put("txtNomeJuiz", juiz_class.getTxtNomeJuiz());
        values2.put("txtIdadeJuiz", juiz_class.getTxtIdadeJuiz());
        values2.put("txtBairroJuiz", juiz_class.getBairroJuiz());
        values2.put("txtTelJuiz",juiz_class.getTxtTelJuiz());
        values2.put("LikeJuiz",juiz_class.getLikeJuiz());
        values2.put("DeslikeJuiz",juiz_class.getDeslikeJuiz());
        getWritableDatabase().insert("juiztab", null, values2);
    }


    public List<Juiz_Class> obterTodos() {
        List<Juiz_Class> juizClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("juiztab", new String[]{"id", "txtLoginJuiz", "txtSenhaJuiz", "txtNomeJuiz", "txtIdadeJuiz","txtBairroJuiz","txtTelJuiz","LikeJuiz","DeslikeJuiz"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Juiz_Class j = new Juiz_Class();
            j.setId(cursor.getInt(0));
            j.setTxtLoginJuiz(cursor.getString(1));
            j.setTxtSenhaJuiz(cursor.getString(2));
            j.setTxtNomeJuiz(cursor.getString(3));
            j.setTxtIdadeJuiz(cursor.getString(4));
            j.setBairroJuiz(cursor.getString(5));
            j.setTxtTelJuiz(cursor.getString(6));
            j.setLikeJuiz(cursor.getInt(7));
            j.setDeslikeJuiz(cursor.getInt(8));
            juizClasses.add(j);
        }
        return juizClasses;
    }


    public List<Juiz_Class> obterTodos1() {
        List<Juiz_Class> juizClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("juiztab", new String[]{"id", "txtLoginJuiz", "txtSenhaJuiz", "txtNomeJuiz", "txtIdadeJuiz","txtBairroJuiz","txtTelJuiz","LikeJuiz","DeslikeJuiz"}, null, null, null, null,"LikeJuiz desc");
        while (cursor.moveToNext()) {
            Juiz_Class j = new Juiz_Class();
            j.setId(cursor.getInt(0));
            j.setTxtLoginJuiz(cursor.getString(1));
            j.setTxtSenhaJuiz(cursor.getString(2));
            j.setTxtNomeJuiz(cursor.getString(3));
            j.setTxtIdadeJuiz(cursor.getString(4));
            j.setBairroJuiz(cursor.getString(5));
            j.setTxtTelJuiz(cursor.getString(6));
            j.setLikeJuiz(cursor.getInt(7));
            j.setDeslikeJuiz(cursor.getInt(8));
            juizClasses.add(j);
        }
        return juizClasses;
    }

    public List<Juiz_Class> obterTodos2() {
        List<Juiz_Class> juizClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("juiztab", new String[]{"id", "txtLoginJuiz", "txtSenhaJuiz", "txtNomeJuiz", "txtIdadeJuiz","txtBairroJuiz","txtTelJuiz","LikeJuiz","DeslikeJuiz"}, null, null, null, null,"DeslikeJuiz desc");
        while (cursor.moveToNext()) {
            Juiz_Class j = new Juiz_Class();
            j.setId(cursor.getInt(0));
            j.setTxtLoginJuiz(cursor.getString(1));
            j.setTxtSenhaJuiz(cursor.getString(2));
            j.setTxtNomeJuiz(cursor.getString(3));
            j.setTxtIdadeJuiz(cursor.getString(4));
            j.setBairroJuiz(cursor.getString(5));
            j.setTxtTelJuiz(cursor.getString(6));
            j.setLikeJuiz(cursor.getInt(7));
            j.setDeslikeJuiz(cursor.getInt(8));
            juizClasses.add(j);
        }
        return juizClasses;
    }

    public int checkUser2 (Juiz_Class us2){
        int id2 = -1;
        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor2 = db2.rawQuery("SELECT id FROM juiztab WHERE txtLoginJuiz = ? AND txtSenhaJuiz = ?", new String[]{us2.getTxtLoginJuiz(),us2.getTxtSenhaJuiz()});
        if (cursor2.getCount()>0){
            cursor2.moveToFirst();
            id2 = cursor2.getInt(0);
            cursor2.close();
        }
        return id2;
    }

    public void like(Juiz_Class jui){
        Integer cont = 1;
        ContentValues values = new ContentValues();
        values.put("LikeJuiz",jui.getLikeJuiz()+cont);
        getWritableDatabase().update("juiztab",values, "id = ?", new String[]{jui.getId().toString()});
    }

    public void Deslike(Juiz_Class jui){
        Integer cont = 1;
        ContentValues values = new ContentValues();
        values.put("DeslikeJuiz",jui.getDeslikeJuiz()+cont);
        getWritableDatabase().update("juiztab",values, "id = ?", new String[]{jui.getId().toString()});
    }

    public void Excluir(Juiz_Class jui){
        getWritableDatabase().delete("juiztab", "id = ?", new String[]{jui.getId().toString()});
    }

}
