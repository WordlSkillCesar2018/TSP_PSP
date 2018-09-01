package com.example.worldskills.tsp_psp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Developer extends SQLiteOpenHelper {
    public Developer(Context context) {
        super(context, "tcp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table proyectos(nombre text)");
        //sqLiteDatabase.execSQL("create table timeLog()");
    //    sqLiteDatabase.execSQL("create table pefectLog ()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<String> llenar() {
        ArrayList listar = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from proyectos", null);
            for (int i = 0 ; i>cursor.getColumnCount();i++){
                listar.add(cursor.getColumnIndexOrThrow("nombre"));
            }
            listar = new ArrayList();
        return  listar;
    }
}

