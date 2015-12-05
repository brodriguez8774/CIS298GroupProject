package com.broadcom.app.wicedsense;

/**
 * Created by jmartin5229 on 11/9/2015.
 */
public class WicedDBSchema {
    public static final class ThermoTable { //  Name of the Table
        public static final String NAME = "thermo";

        public static final class Cols { //  Name of the Columns (Fields)
            public static final String TIME = "time";
            public static final String HUMIDITY = "humidity";
            public static final String PRESSURE = "pressure";
            public static final String TEMPERATURE = "temerature";

        }
    }
}
