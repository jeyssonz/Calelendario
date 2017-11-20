package com.uninorte.basedatos;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText Hora,Mensaje;
String[] Día = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
String DBName;
private int hora,minuto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hora = (EditText) findViewById(R.id.texto_Hora);
        Mensaje = (EditText) findViewById(R.id.texto_Mensaje);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Día));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                DBName=(String) adapterView.getItemAtPosition(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }
        });
    }



    public void Guardar(View view) {
        String Tiempo,Curso;
        Tiempo=Hora.getText().toString();
        Curso= Mensaje.getText().toString();



BDDias elDia = new BDDias(this , DBName,null , 1);
        SQLiteDatabase  db = elDia.getWritableDatabase();
        if (db != null)
        {
            switch (DBName)
            {
                case "Lunes":
                {
                    db.execSQL("INSERT INTO Lunes (Hora, curso) " +
                            "VALUES ('" + Tiempo + "', '" + Curso + "')" );
                        db.close();
                    break;
                }
                case  "Martes":
                    db.execSQL("INSERT INTO Martes (Hora, curso) VALUES ('" + Tiempo + "','" + Curso + "') " );
                    break;
                case "Miercles":
                    db.execSQL("INSERT INTO Miercles (Hora, curso) VALUES ('" + Tiempo + "','" + Curso + "') " );
                    break;
                case "Jueves":
                    db.execSQL("INSERT INTO Jueves (Hora, curso) VALUES ('" + Tiempo + "','" + Curso + "') " );
                    break;
                case "Viernes":
                    db.execSQL("INSERT INTO Viernes (Hora, curso) VALUES ('" + Tiempo + "','" + Curso + "') " );
                    break;
                case "Sabado":
                    db.execSQL("INSERT INTO Sabado (Hora, curso) VALUES ('" + Tiempo + "','" + Curso + "') " );
                    break;
                case "Domingo":
                    db.execSQL("INSERT INTO Domingo (Hora, curso) VALUES ('" + Tiempo + "','" + Curso + "') " );
                    break;
            }


            db.close();
        }

    }

    public void Dar_Hora(View view) {
        final Calendar c =Calendar.getInstance();
        hora=c.get(Calendar.HOUR_OF_DAY);
        minuto=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDasy, int elMinuto) {
                    Hora.setText(hourOfDasy + ":" + elMinuto);
            }
        },hora,minuto,false);
        timePickerDialog.show();

    }

    public void Ver(View view) {

        Intent intent = new Intent(this,ver.class);
        intent.putExtra("i",DBName);
        startActivity(intent);



    }
}
