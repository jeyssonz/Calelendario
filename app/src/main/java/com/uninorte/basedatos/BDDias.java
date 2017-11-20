package com.uninorte.basedatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Json on 17/11/2017.
 */

public class BDDias extends SQLiteOpenHelper {

    String Lunes = "CREATE TABLE Lunes (Hora TEXT, curso TEXT)";
    String Martes = "CREATE TABLE Martes (Hora TEXT, curso TEXT)";
    String Miercoles = "CREATE TABLE Miercoles (Hora TEXT, curso TEXT)";
    String Jueves = "CREATE TABLE Jueves (Hora TEXT, curso TEXT)";
    String Viernes = "CREATE TABLE Viernes (Hora TEXT, curso TEXT)";
    String Sabado = "CREATE TABLE Sabado (Hora TEXT, curso TEXT)";
    String Domingo = "CREATE TABLE Domingo (Hora TEXT, curso TEXT)";



    public BDDias(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // si no existe la base de datos la crea y ejecuta los siguientes comandos
    db.execSQL(Lunes);
    db.execSQL(Martes);
    db.execSQL(Miercoles);
    db.execSQL(Jueves);
    db.execSQL(Viernes);
    db.execSQL(Sabado);
    db.execSQL(Domingo);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Lunes");
        db.execSQL("DROP TABLE IF EXISTS Martes");
        db.execSQL("DROP TABLE IF EXISTS Miercoles");
        db.execSQL("DROP TABLE IF EXISTS Jueves");
        db.execSQL("DROP TABLE IF EXISTS Viernes");
        db.execSQL("DROP TABLE IF EXISTS Sabado");
        db.execSQL("DROP TABLE IF EXISTS Domingo");

    }
}
