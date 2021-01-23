package com.example.crimereport1.DB;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.crimereport1.Crime;

import java.util.Date;
import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String id = getString(getColumnIndex(CrimeSchema.CrimeTable.Cols.UUID));
        String TITLE = getString(getColumnIndex(CrimeSchema.CrimeTable.Cols.TITLE));
        Long DATE = getLong(getColumnIndex(CrimeSchema.CrimeTable.Cols.DATE));
        boolean SOLVED =  getInt(getColumnIndex(CrimeSchema.CrimeTable.Cols.SOLVED)) != 1;


        Crime crime = new Crime(UUID.fromString(id));

        crime.setDate(new Date(DATE));
        crime.setSolved(SOLVED);
        crime.setTitle(TITLE);


        return  crime;
    }
}
