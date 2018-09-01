package com.example.worldskills.tsp_psp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DefecLog extends AppCompatActivity {

    Spinner a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defec_log);
        String[] spiner1 = new String[]{""};
        String[] spiner2 = new String[]{""};
        a=findViewById(R.id.spinner);
        b=findViewById(R.id.spinner2);
        c=findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spiner1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,spiner2);
        a.setAdapter(adapter);
        b.setAdapter(adapter1);
        c.setAdapter(adapter1);
    }


}
