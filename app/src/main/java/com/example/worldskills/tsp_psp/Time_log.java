package com.example.worldskills.tsp_psp;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time_log extends AppCompatActivity {
Spinner spinner;
TextView hinicio,hfin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);
        hinicio=findViewById(R.id.hinicio);
        spinner=findViewById(R.id.spin);
        hfin = findViewById(R.id.textView7);
        String[] fase=new String[]{"PLAN","DLD","CODE","COMPILE","UT","PM"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fase);
        spinner.setAdapter(adapter);
    }

    public void inicio(View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        String a = simpleDateFormat1.format(date)+" "+simpleDateFormat.format(date);
        hinicio.setText(a);
    }

    public void parar(View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        String a = simpleDateFormat1.format(date)+" "+simpleDateFormat.format(date);
        hfin.setText(a);
    }

    public void registro(View view) {
        Developer developer = new Developer(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = developer.getWritableDatabase();
        //sqLiteDatabase.execSQL("insert into timeLog values ('"++"','"++"','"++"','"++"','"++"',) ");
        Toast.makeText(getApplicationContext(),"Timelog Guardado", Toast.LENGTH_LONG).show();
    }
}
