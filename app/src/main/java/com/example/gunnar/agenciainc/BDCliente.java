package com.example.gunnar.agenciainc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Clase para la Base de Datos de Cliente
 * Created by ${Alejandra} on 02/11/2016.
 */

class BDCliente extends SQLiteOpenHelper {
        private static final String TAG = BDCliente.class.getSimpleName();

        private static final String TABLE_CLIENTE_IMPORTADORA = "Cliente";
        private static final String COLUMN_ID = "_id";
        private static final String COLUMN_NOMBRE = "nombre";
        private static final String COLUMN_SEXO = "sexo";
        private static final String COLUMN_TELEFONO = "telefono";

        private static final String DATABASE_CLIENTE = "BaseDatosCliente.db";
        private static final int DATABASE_VERSION = 1;

        //Setencia SQL para crear la base de datos
        private static final String DATABASE_CREATE = "CREATE TABLE"
                + TABLE_CLIENTE_IMPORTADORA + "(" + COLUMN_ID + " TEXT PRIMARY KEY,"
                + COLUMN_NOMBRE + "TEXT NOT NULL,"
                + COLUMN_SEXO + "TEXT NOT NULL,"
                + COLUMN_TELEFONO + "TEXT NOT NULL);";

        BDCliente(Context context){
            super(context, DATABASE_CLIENTE, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            //Ejecuta la sentencia SQL y crea la base de datos
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgradind database from version " + oldVersion + "to" + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTE_IMPORTADORA);
            onCreate(db);
        }
    }
