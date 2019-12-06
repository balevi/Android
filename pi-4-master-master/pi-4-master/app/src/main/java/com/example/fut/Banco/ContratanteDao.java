package com.example.fut.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContratanteDao extends SQLiteOpenHelper {
    public ContratanteDao(Context context) {
        super(context, "banco.db6", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "create table contratab(id integer primary key autoincrement, txtLoginCont varchar (50),txtSenhaCont varchar(50))";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserir(ContratanteClass contratanteClass){
        ContentValues values = new ContentValues();
        values.put("txtLoginCont",contratanteClass.getTxtLoginCont());
        values.put("txtSenhaCont",contratanteClass.getTxtSenhaCont());
        getWritableDatabase().insert("contratab", null, values);
    }

    public int checkUser4 (ContratanteClass us){
        int id = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM contratab WHERE txtLoginCont = ? AND txtSenhaCont = ?", new String[]{us.getTxtLoginCont(),us.getTxtSenhaCont()});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            id = cursor.getInt(0);
            cursor.close();
        }
        return id;
    }

    public void Excluir(ContratanteClass us){
        getWritableDatabase().delete("contratab", "id = ?", new String[]{us.getId().toString()});
    }
}
