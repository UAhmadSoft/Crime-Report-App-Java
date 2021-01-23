package com.example.crimereport1.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CrimeDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "CrimeDB1.db";
    private static final int VERSION = 1;


    public CrimeDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =  "CREATE TABLE " + CrimeSchema.CrimeTable.NAME + "(" +
                "_id integer primary key autoincrement," +
                CrimeSchema.CrimeTable.Cols.UUID + "," +
                CrimeSchema.CrimeTable.Cols.TITLE + "," +
                CrimeSchema.CrimeTable.Cols.DATE + "," +
                CrimeSchema.CrimeTable.Cols.SOLVED +
                ")";

        db.execSQL(query);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
