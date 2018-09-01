package com.example.worldskills.tsp_psp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DefecLog extends AppCompatActivity {

    Chronometer chronometer;
    EditText defectos;
    TextView tiempo;
    Spinner a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defec_log);
        String[] type = new String[]{"Documentation", "Syntax", "Build", " Package", "Assigment", "Interface", "Checking", "Data", "Function", "System","Emvironment"};
        String[] fases = new String[]{"PLAN","DLD","CODE","COMPILE","UT","PM"};
        a=findViewById(R.id.spinner);
        b=findViewById(R.id.spinner2);
        c=findViewById(R.id.spinner3);
        tiempo = findViewById(R.id.editText2);
        defectos = findViewById(R.id.editText3);
        chronometer = findViewById(R.id.cronometro);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,type);
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,fases);
        a.setAdapter(adapter);
        b.setAdapter(adapter1);
        c.setAdapter(adapter1);
    }

    @SuppressLint("NewApi")
    public void restart(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    public void Stop(View view) {
        chronometer.stop();
    }

    public void Start(View view) {
        chronometer.start();
    }

    public void registroo(View view) {
        String date,type,pi,pr,fix,defect;
        date= tiempo.getText().toString();
        type =a.getSelectedItem().toString();
        pi=b.getSelectedItem().toString();
        pr=c.getSelectedItem().toString();
        fix=chronometer.getText().toString();
        defect=defectos.getText().toString();
        Developer developer = new Developer(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = developer.getWritableDatabase();
        sqLiteDatabase.execSQL("insert into defectLog values ('"+date+"','"+type+"','"+pi+"','"+pr+"','"+fix+"','"+defect+"')");
        Intent intent = new Intent(this,DefecLog.class);
        startActivity(intent);
        finish();
    }

    public void date(View view) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
        String a = simpleDateFormat1.format(date)+" "+simpleDateFormat.format(date);
        tiempo.setText(a);
    }
}
