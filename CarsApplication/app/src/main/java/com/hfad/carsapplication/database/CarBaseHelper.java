package com.hfad.carsapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CarBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final  String DTABASE_NAME = "carBase.db";
    public CarBaseHelper(Context context) {
        super(context, DTABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+CarDbSchema.CarTable.NAME+"(" +
                "_id integer primary key autoincrement, " +
                CarDbSchema.Cols.UUID+", " +
                CarDbSchema.Cols.CARNUMBER+", " +
                CarDbSchema.Cols.CARMODEL+", " +
                CarDbSchema.Cols.CARCOLOR+", " +
                CarDbSchema.Cols.CARYEAR+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}