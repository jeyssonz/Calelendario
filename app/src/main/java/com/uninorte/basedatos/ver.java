package com.uninorte.basedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ver extends AppCompatActivity {

    ListView Lv;
    ArrayList<String> Lalista;
    ArrayAdapter adaptador;
    String DBName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);
        Lv = (ListView)findViewById(R.id.lista);
        DBName = getIntent().getStringExtra("i");
        BDDias elDia = new BDDias(this , DBName,null , 1);
        //lista a array list
        SQLiteDatabase db = elDia.getWritableDatabase();
        String q=null;
        switch (DBName) {

            case  "Lunes":
                q = "SELECT * FROM Lunes ORDER BY Hora ASC";
                break;
            case  "Martes":
                 q = "SELECT * FROM Martes ORDER BY Hora ASC";
                break;
            case  "Miercoles":
                 q = "SELECT * FROM Miercoles ORDER BY Hora ASC";
                break;
            case  "Jueves":
                 q = "SELECT * FROM Jueves ORDER BY Hora ASC";
                break;
            case  "Viernes":
                 q = "SELECT * FROM Viernes ORDER BY Hora ASC";
                break;
            case  "Sabado":
                 q = "SELECT * FROM Sabado ORDER BY Hora ASC";
                break;
            case  "Domingo":
                 q = "SELECT * FROM Domingo ORDER BY Hora ASC";
                break;
        }
        Cursor registros = db.rawQuery(q,null);
        this.Lalista = new ArrayList<String>();
        if(registros.moveToFirst())
        {
            do{
                Lalista.add(registros.getString(0) + " " + registros.getString(1));
            }while (registros.moveToNext());
        }

        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,Lalista);
        Lv.setAdapter(adaptador);

    }
}
