package com.broadcom.app.wicedsense;

/**
 * Created by jmartin5229 on 11/9/2015.
 */
public class WicedDBSchema {  //These are used to define the name and  fields of the tables. By placing the fields in columns,
    //this helps to differentiate that they are fields in the database.

    //Define the ThermoTable.
    public static final class ThermoTable { //  Name of the Table
        public static final String NAME = "thermo";

        public static final class Cols { //  Name of the Columns (Fields)
            public static final String TIME = "time";
            public static final String HUMIDITY = "humidity";
            public static final String PRESSURE = "pressure";
            public static final String TEMPERATURE = "temerature";

        }
    }//Define the MovementTable
    public static final class MovementTable {
        public static final String NAME = "movement";

        public static final class Cols {
            public static final String TIME = "time";
            public static final String ACCELEROMETER_0 = "accelerometer_0";
            public static final String ACCELEROMETER_1 = "accelerometer_1";
            public static final String ACCELEROMETER_2 = "accelerometer_2";
            public static final String GYRO_0 = "gyro_0";
            public static final String GYRO_1 = "gyro_1";
            public static final String GYRO_2 = "gyro_2";
            public static final String MAGNETOMETER_0 = "magnetometer_0";
            public static final String MAGNETOMETER_1 = "magnetometer_1";
            public static final String MAGNETOMETER_2 = "magnetometer_2";
        }
    }
}
