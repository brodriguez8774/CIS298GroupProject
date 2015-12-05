package com.broadcom.app.wicedsense;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by jmartin5229 on 11/9/2015.
 */
public class ThermoBaseHelper  extends SQLiteOpenHelper {// The SQLiteOpenHelper does the following
    // 1. Check to see if the database already exists.
    // 2. If it does not, create it and create the tables and initial data it needs.
    // 3. If it does, open it up and see what version of your ThermoDbSchema it has.
    // 4. If it is an old version, run code to upgrade it to a newer version.
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "/mnt/sdcard/thermoBase.db";

    public ThermoBaseHelper(Context context) {
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int newVersion){

    }
}
