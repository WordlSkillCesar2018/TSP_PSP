package com.example.worldskills.tsp_psp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText nombreproyecto;
    ListView listadeproyectos;
    ArrayList<String> listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nombreproyecto = findViewById(R.id.editText);
        listadeproyectos = findViewById(R.id.lista);
        Developer developer = new Developer(getApplicationContext());
        listar = new ArrayList();
        //listar= developer.llenar();
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listar);
        //listadeproyectos.setAdapter(arrayAdapter);



    }



    public void registrarproyecto(View view) {
        String a = nombreproyecto.getText().toString();
        Developer developer = new Developer(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = developer.getWritableDatabase();
        if (sqLiteDatabase!=null){
            sqLiteDatabase.execSQL("insert into Proyectos values ('"+a+"')");
            Toast.makeText(getApplicationContext(),"Proyecto registrado",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
