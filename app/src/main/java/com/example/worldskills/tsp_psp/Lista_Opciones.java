package com.example.worldskills.tsp_psp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Lista_Opciones extends AppCompatActivity {

    RadioButton r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__opciones);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        r1.setChecked(true);
    }


    public void siguiente(View view) {
        if (r1.isChecked()){
            Intent intent = new Intent(this,DefecLog.class);
            String a = getIntent().getExtras().getString("nombre");
            intent.putExtra("nombre1",a);
            startActivity(intent);
        }if (r2.isChecked()){
            Intent intent = new Intent(this,DefecLog.class);
            String a = getIntent().getExtras().getString("nombre");
            intent.putExtra("nombre1",a);
            startActivity(intent);
        }if (r3.isChecked()){
            Intent intent = new Intent(this,DefecLog.class);
            String a = getIntent().getExtras().getString("nombre");
            intent.putExtra("nombre1",a);
            startActivity(intent);
        }
    }
}
