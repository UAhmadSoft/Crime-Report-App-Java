package com.example.crimereport1.DB;

public class CrimeSchema {

    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "Title";
            public static final String DATE = "Date";
            public static final String SOLVED = "Solved";
        }
    }
}
