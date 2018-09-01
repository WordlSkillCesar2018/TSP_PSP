package com.example.worldskills.tsp_psp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText nombreproyecto;
    ListView listadeproyectos;
    ArrayList<String> listar=new ArrayList<>();
    Developer developer;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nombreproyecto = findViewById(R.id.editText);
        listadeproyectos = findViewById(R.id.aaaa);
         developer = new Developer(getApplicationContext());
         sqLiteDatabase = developer.getWritableDatabase();

        //Cursor cursor = sqLiteDatabase.rawQuery("select * from proyectos", null);

        listadeproyectos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String a = listadeproyectos.getItemAtPosition(i).toString();
                Intent intent = new Intent(MainActivity.this,Lista_Opciones.class);
                intent.putExtra("nombre",a);
                startActivity(intent);

            }
        });
        if (sqLiteDatabase!= null){
            Cursor cursor = sqLiteDatabase.rawQuery("select * from proyectos",null);
            //StringBuffer stringBuffer = new StringBuffer();
            while (cursor.moveToNext()){
                listar.add(cursor.getString(0));

            }
            //nombre.setText(stringBuffer.toString());
        }

     //   nombreproyecto.setText(cursor.getString(0));
            //Toast.makeText(this,cursor.getString(0),Toast.LENGTH_SHORT).show();
            //listar.add(cursor.getString(2));


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listar);
        listadeproyectos.setAdapter(adapter);

    }



    public void registrarproyecto(View view) {
        String a = nombreproyecto.getText().toString();
        if (sqLiteDatabase!=null){
            sqLiteDatabase.execSQL("insert into Proyectos values ('"+a+"')");
            Toast.makeText(getApplicationContext(),"Proyecto registrado",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
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
