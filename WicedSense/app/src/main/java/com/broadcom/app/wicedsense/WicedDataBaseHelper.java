package com.broadcom.app.wicedsense;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by jmartin5229 on 11/9/2015.
 */
public class WicedDataBaseHelper extends SQLiteOpenHelper {// The SQLiteOpenHelper does the following
    // 1. Check to see if the database already exists.
    // 2. If it does not, create it and create the tables and initial data it needs.
    // 3. If it does, open it up and see what version of your ThermoDbSchema it has.
    // 4. If it is an old version, run code to upgrade it to a newer version.
    private static final int VERSION = 2;
    private static final String DATABASE_NAME = "WicedDataBase.db";
    private static final String JEFF_TAG = "Jeff_Tag";

    public WicedDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){  //  Creates the ThermoTable and defines its fields.
        db.execSQL("create table " + WicedDBSchema.ThermoTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        WicedDBSchema.ThermoTable.Cols.TIME + ", "+
                        WicedDBSchema.ThermoTable.Cols.HUMIDITY + ", " +
                        WicedDBSchema.ThermoTable.Cols.PRESSURE + ", " +
                        WicedDBSchema.ThermoTable.Cols.TEMPERATURE + ")"
        );
        String tempString = "create table " + WicedDBSchema.MovementTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                WicedDBSchema.MovementTable.Cols.TIME + ", "+
                WicedDBSchema.MovementTable.Cols.ACCELEROMETER_0 + ", " +
                WicedDBSchema.MovementTable.Cols.ACCELEROMETER_1 + ", " +
                WicedDBSchema.MovementTable.Cols.ACCELEROMETER_2 + ", " +
                WicedDBSchema.MovementTable.Cols.GYRO_0 + ", " +
                WicedDBSchema.MovementTable.Cols.GYRO_1 + ", " +
                WicedDBSchema.MovementTable.Cols.GYRO_2 + ", " +
                WicedDBSchema.MovementTable.Cols.MAGNETOMETER_0 + ", " +
                WicedDBSchema.MovementTable.Cols.MAGNETOMETER_1+ ", " +
                WicedDBSchema.MovementTable.Cols.MAGNETOMETER_2 + ")";
        db.execSQL("create table " + WicedDBSchema.MovementTable.NAME + "(" +
                        " _id integer primary key autoincrement, " +
                        WicedDBSchema.MovementTable.Cols.TIME + ", "+
                        WicedDBSchema.MovementTable.Cols.ACCELEROMETER_0 + ", " +
                        WicedDBSchema.MovementTable.Cols.ACCELEROMETER_1 + ", " +
                        WicedDBSchema.MovementTable.Cols.ACCELEROMETER_2 + ", " +
                        WicedDBSchema.MovementTable.Cols.GYRO_0 + ", " +
                        WicedDBSchema.MovementTable.Cols.GYRO_1 + ", " +
                        WicedDBSchema.MovementTable.Cols.GYRO_2 + ", " +
                        WicedDBSchema.MovementTable.Cols.MAGNETOMETER_0 + ", " +
                        WicedDBSchema.MovementTable.Cols.MAGNETOMETER_1+ ", " +
                        WicedDBSchema.MovementTable.Cols.MAGNETOMETER_2 + ")"
        );
        Log.d(JEFF_TAG, tempString);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion){

    }

    public Cursor getAllData(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor res = database.rawQuery("select * from "+ DATABASE_NAME,null);
        return res;
    }
}
