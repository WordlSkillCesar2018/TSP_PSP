package com.example.worldskills.tsp_psp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
class Fragment1 extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.fragment1,null,false);
        TextView texto = (TextView) view.findViewById(R.id.textView6);
        Developer developer = new Developer(getContext());
        SQLiteDatabase db = developer.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from timeLog",null);
        StringBuffer stringBuffer = new StringBuffer();
        if (cursor.moveToFirst()){
            stringBuffer.append(cursor.getString(0)+"\n"+cursor.getString(1)+"\n"+cursor.getString(2)+"\n"+cursor.getString(3)+"\n"+cursor.getString(4)+"\n"+cursor.getString(5)+"\n"+cursor.getString(6));
        }

        return view;
    }
}
