package com.csto.prueba3;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper{
    public static String Nombre_BD = "Prueba3.db";
    public static int Version_DB = 1;
    public static String Tabla_voto="create table voto (id_voto integer primary key autoincrement, voto_blanco integer, voto_nulo integer, voto_boric integer, voto_kast integer)";

    public Dbhelper(Context context) {
        super(context, Nombre_BD, null, Version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_voto);
        sqLiteDatabase.execSQL("insert into voto (id_voto, voto_blanco, voto_nulo, voto_boric, voto_kast) values (0,0,0,0,0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists voto");
        sqLiteDatabase.execSQL(Tabla_voto);

    }
}
