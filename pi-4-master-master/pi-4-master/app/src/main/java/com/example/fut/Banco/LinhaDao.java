package com.example.fut.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class LinhaDao extends SQLiteOpenHelper {


    public LinhaDao(Context context) {
        super(context, "banco.db2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql1 = "create table linhatab(id integer primary key autoincrement, txtLoginLinha varchar (50),txtSenhaLinha varchar(50),txtNomeLinha varchar(50), txtIdadeLinha varchar(50)," +
                "txtAlturaLinha varchar (50), txtPesoLinha varchar (50),txtBairroLinha varchar(50),spinLinha varchar(50),TxtTelLinha varchar(12),LikeLinha integer(3),DeslikeLinha integer(3))";

        db.execSQL(sql1);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void inserir2(Linha_class linha_class) {
        ContentValues values1 = new ContentValues();
        values1.put("txtLoginLinha", linha_class.getTxtLoginLinha());
        values1.put("txtSenhaLinha", linha_class.getTxtSenhaLinha());
        values1.put("txtNomeLinha", linha_class.getTxtNomeLinha());
        values1.put("txtIdadeLinha", linha_class.getTxtIdadeLinha());
        values1.put("txtAlturaLinha", linha_class.getTxtAlturaLinha());
        values1.put("txtPesoLinha", linha_class.getTxtPesoLinha());
        values1.put("txtBairroLinha", linha_class.getTxtBairroLinha());
        values1.put("spinLinha",linha_class.getSpinLinha());
        values1.put("txtTelLinha", linha_class.getTxtTelLinha());
        values1.put("LikeLinha", linha_class.getLikeLinha());
        values1.put("DeslikeLinha", linha_class.getDeslikeLinha());
        getWritableDatabase().insert("linhatab", null, values1);
    }

    public List<Linha_class> obterTodos() {
        List<Linha_class> linhaClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("linhatab", new String[]{"id", "txtLoginLinha", "txtSenhaLinha", "txtNomeLinha", "txtIdadeLinha", "txtAlturaLinha", "txtPesoLinha", "txtBairroLinha","spinLinha","txtTelLinha","LikeLinha","DeslikeLinha"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Linha_class l = new Linha_class();
            l.setId(cursor.getInt(0));
            l.setTxtLoginLinha(cursor.getString(1));
            l.setTxtSenhaLinha(cursor.getString(2));
            l.setTxtNomeLinha(cursor.getString(3));
            l.setTxtIdadeLinha(cursor.getString(4));
            l.setTxtAlturaLinha(cursor.getString(5));
            l.setTxtPesoLinha(cursor.getString(6));
            l.setTxtBairroLinha(cursor.getString(7));
            l.setSpinLinha(cursor.getString(8));
            l.setTxtTelLinha(cursor.getString(9));
            l.setLikeLinha(cursor.getInt(10));
            l.setDeslikeLinha(cursor.getInt(11));
            linhaClasses.add(l);       }
        return linhaClasses;
    }

    public List<Linha_class> obterTodos1() {
        List<Linha_class> linhaClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("linhatab", new String[]{"id", "txtLoginLinha", "txtSenhaLinha", "txtNomeLinha", "txtIdadeLinha", "txtAlturaLinha", "txtPesoLinha", "txtBairroLinha","spinLinha","txtTelLinha","LikeLinha","DeslikeLinha"}, null, null, null, null, "LikeLinha desc");
        while (cursor.moveToNext()) {
            Linha_class l = new Linha_class();
            l.setId(cursor.getInt(0));
            l.setTxtLoginLinha(cursor.getString(1));
            l.setTxtSenhaLinha(cursor.getString(2));
            l.setTxtNomeLinha(cursor.getString(3));
            l.setTxtIdadeLinha(cursor.getString(4));
            l.setTxtAlturaLinha(cursor.getString(5));
            l.setTxtPesoLinha(cursor.getString(6));
            l.setTxtBairroLinha(cursor.getString(7));
            l.setSpinLinha(cursor.getString(8));
            l.setTxtTelLinha(cursor.getString(9));
            l.setLikeLinha(cursor.getInt(10));
            l.setDeslikeLinha(cursor.getInt(11));
            linhaClasses.add(l);       }
        return linhaClasses;
    }

    public List<Linha_class> obterTodos2() {
        List<Linha_class> linhaClasses = new ArrayList<>();
        Cursor cursor = getWritableDatabase().query("linhatab", new String[]{"id", "txtLoginLinha", "txtSenhaLinha", "txtNomeLinha", "txtIdadeLinha", "txtAlturaLinha", "txtPesoLinha", "txtBairroLinha","spinLinha","txtTelLinha","LikeLinha","DeslikeLinha"}, null, null, null, null, "DeslikeLinha desc");
        while (cursor.moveToNext()) {
            Linha_class l = new Linha_class();
            l.setId(cursor.getInt(0));
            l.setTxtLoginLinha(cursor.getString(1));
            l.setTxtSenhaLinha(cursor.getString(2));
            l.setTxtNomeLinha(cursor.getString(3));
            l.setTxtIdadeLinha(cursor.getString(4));
            l.setTxtAlturaLinha(cursor.getString(5));
            l.setTxtPesoLinha(cursor.getString(6));
            l.setTxtBairroLinha(cursor.getString(7));
            l.setSpinLinha(cursor.getString(8));
            l.setTxtTelLinha(cursor.getString(9));
            l.setLikeLinha(cursor.getInt(10));
            l.setDeslikeLinha(cursor.getInt(11));
            linhaClasses.add(l);       }
        return linhaClasses;
    }

    public int checkUser3 (Linha_class us3){
        int id3 = -1;
        SQLiteDatabase db3 = this.getReadableDatabase();
        Cursor cursor3 = db3.rawQuery("SELECT id FROM linhatab WHERE txtLoginLinha = ? AND txtSenhaLinha = ?", new String[]{us3.getTxtLoginLinha(),us3.getTxtSenhaLinha()});
        if (cursor3.getCount()>0){
            cursor3.moveToFirst();
            id3 = cursor3.getInt(0);
            cursor3.close();
        }
        return id3;
    }

    public void like(Linha_class lin){
        Integer cont = 1;
        ContentValues values = new ContentValues();
        values.put("LikeLinha",lin.getLikeLinha()+cont);
        getWritableDatabase().update("linhatab",values, "id = ?", new String[]{lin.getId().toString()});
    }

    public void Deslike(Linha_class lin){
        Integer cont = 1;
        ContentValues values = new ContentValues();
        values.put("DeslikeLinha",lin.getDeslikeLinha()+cont);
        getWritableDatabase().update("linhatab",values, "id = ?", new String[]{lin.getId().toString()});
    }
    public void Excluir(Linha_class lin){
        getWritableDatabase().delete("linhatab", "id = ?", new String[]{lin.getId().toString()});
    }
}
