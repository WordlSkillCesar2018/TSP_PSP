package com.example.worldskills.tsp_psp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class Time_log extends AppCompatActivity {
Spinner spinner;
TextView hinicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);
        hinicio=findViewById(R.id.hinicio);
        spinner=findViewById(R.id.spin);
        String[] fase=new String[]{"PLAN","DLD","CODE","COMPILE","UT","PM"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fase);
        spinner.setAdapter(adapter);
    }

    public void inicio(View view) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat fecha=new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
        String a= String.valueOf(fecha);
        hinicio.setText((CharSequence) a);

    }

    public void parar(View view) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat fecha=new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");
        hinicio.setText((CharSequence) fecha);
    }
}
