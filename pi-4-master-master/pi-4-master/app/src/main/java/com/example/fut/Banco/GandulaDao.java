package com.example.fut.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class GandulaDao extends SQLiteOpenHelper {
    public GandulaDao(Context context) {
        super(context, "Banco.db4", null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql3 = "create table gandtab(id integer primary key autoincrement, txtLoginGand varchar (50),txtSenhaGand varchar(50),txtNomeGand varchar(50), txtIdadeGand varchar(50),txtBairroGand varchar(50),txtTelGand varchar (12),LikeGand integer(3),DeslikeGand integer(3))";

        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserir4(Gandula_Class gandula_class) {
        ContentValues values3 = new ContentValues();
        values3.put("txtLoginGand", gandula_class.getTxtLoginGand());
        values3.put("txtSenhaGand", gandula_class.getTxtSenhaGand());
        values3.put("txtNomeGand", gandula_class.getTxtNomeGand());
        values3.put("txtIdadeGand", gandula_class.getTxtIdadeGand());
        values3.put("txtBairroGand", gandula_class.getTxtBairroGand());
        values3.put("txtTelGand", gandula_class.getTxtTelGand());
        values3.put("LikeGand",gandula_class.getLikeGand());
        values3.put("DeslikeGand",gandula_class.getDeslikeGand());
        getWritableDatabase().insert("gandtab", null, values3);
    }

    public List<Gandula_Class> obterTodos() {
        List<Gandula_Class> gandulaClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("gandtab", new String[]{"id", "txtLoginGand", "txtSenhaGand", "txtNomeGand", "txtIdadeGand","txtBairroGand","txtTelGand","LikeGand","DeslikeGand"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Gandula_Class ga = new Gandula_Class();
            ga.setId(cursor.getInt(0));
            ga.setTxtLoginGand(cursor.getString(1));
            ga.setTxtSenhaGand(cursor.getString(2));
            ga.setTxtNomeGand(cursor.getString(3));
            ga.setTxtIdadeGand(cursor.getString(4));
            ga.setTxtBairroGand(cursor.getString(5));
            ga.setTxtTelGand(cursor.getString(6));
            ga.setLikeGand(cursor.getInt(7));
            ga.setDeslikeGand(cursor.getInt(8));
            gandulaClasses.add(ga);
        }
        return gandulaClasses;
    }

    public List<Gandula_Class> obterTodos1() {
        List<Gandula_Class> gandulaClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("gandtab", new String[]{"id", "txtLoginGand", "txtSenhaGand", "txtNomeGand", "txtIdadeGand","txtBairroGand","txtTelGand","LikeGand","DeslikeGand"}, null, null, null, null,"LikeGand desc" );
        while (cursor.moveToNext()) {
            Gandula_Class ga = new Gandula_Class();
            ga.setId(cursor.getInt(0));
            ga.setTxtLoginGand(cursor.getString(1));
            ga.setTxtSenhaGand(cursor.getString(2));
            ga.setTxtNomeGand(cursor.getString(3));
            ga.setTxtIdadeGand(cursor.getString(4));
            ga.setTxtBairroGand(cursor.getString(5));
            ga.setTxtTelGand(cursor.getString(6));
            ga.setLikeGand(cursor.getInt(7));
            ga.setDeslikeGand(cursor.getInt(8));
            gandulaClasses.add(ga);
        }
        return gandulaClasses;
    }

    public List<Gandula_Class> obterTodos2() {
        List<Gandula_Class> gandulaClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("gandtab", new String[]{"id", "txtLoginGand", "txtSenhaGand", "txtNomeGand", "txtIdadeGand","txtBairroGand","txtTelGand","LikeGand","DeslikeGand"}, null, null, null, null,"DeslikeGand desc" );
        while (cursor.moveToNext()) {
            Gandula_Class ga = new Gandula_Class();
            ga.setId(cursor.getInt(0));
            ga.setTxtLoginGand(cursor.getString(1));
            ga.setTxtSenhaGand(cursor.getString(2));
            ga.setTxtNomeGand(cursor.getString(3));
            ga.setTxtIdadeGand(cursor.getString(4));
            ga.setTxtBairroGand(cursor.getString(5));
            ga.setTxtTelGand(cursor.getString(6));
            ga.setLikeGand(cursor.getInt(7));
            ga.setDeslikeGand(cursor.getInt(8));
            gandulaClasses.add(ga);
        }
        return gandulaClasses;
    }

    public int checkUser1 (Gandula_Class us1){
        int id1 = -1;
        SQLiteDatabase db1 = this.getReadableDatabase();
        Cursor cursor1 = db1.rawQuery("SELECT id FROM gandtab WHERE txtLoginGand = ? AND txtSenhaGand = ?", new String[]{us1.getTxtLoginGand(),us1.getTxtSenhaGand()});
        if (cursor1.getCount()>0){
            cursor1.moveToFirst();
            id1 = cursor1.getInt(0);
            cursor1.close();
        }
        return id1;
    }

    public void like(Gandula_Class gand){
        Integer cont = 1;
        ContentValues values = new ContentValues();
        values.put("LikeGand",gand.getLikeGand()+cont);
        getWritableDatabase().update("gandtab",values, "id = ?", new String[]{gand.getId().toString()});
    }

    public void Deslike(Gandula_Class gand){
        Integer cont = 1;
        ContentValues values = new ContentValues();
        values.put("DeslikeGand",gand.getDeslikeGand()+cont);
        getWritableDatabase().update("gandtab",values, "id = ?", new String[]{gand.getId().toString()});
    }

    public void Excluir(Gandula_Class gand){
        getWritableDatabase().delete("gandtab", "id = ?", new String[]{gand.getId().toString()});
    }

}
