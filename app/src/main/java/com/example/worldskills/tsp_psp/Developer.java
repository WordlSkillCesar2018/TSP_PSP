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
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table proyectos(nombre text)");
        db.execSQL("create table timeLog(nombre text, phase text,star text,stop text,delta text, comments text, timetotal text)");
        db.execSQL("create table defectLog (nombre text, Date text, Type text, phase_inyected text, phase_removed text, fixtime text, defect text, timetotal text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

