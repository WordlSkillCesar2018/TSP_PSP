package com.example.worldskills.tsp_psp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TimeLog extends AppCompatActivity {
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timelog);
        spinner=findViewById(R.id.spinner);
        String[] fase=new String[]{"PLAN","DLD","CODE","COMPILE","UT","PM"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fase);
        spinner.setAdapter(adapter);



    }
}
