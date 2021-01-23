package com.example.crimereport1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.crimereport1.DB.CrimeDBHelper;
import com.example.crimereport1.DB.CrimeSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
//    private  static List<Crime> mCrimes;
    private SQLiteDatabase sqLiteDatabase;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
//        mCrimes = new ArrayList<>();

        sqLiteDatabase = new CrimeDBHelper(context.getApplicationContext()).getWritableDatabase();



//        for (int i = 0; i < 100; i++) {
//            Crime crime = new Crime();
//            crime.setTitle("Crime #" + i);
//            crime.setSolved(i % 2 == 0); // Every other one
//            mCrimes.add(crime);
//        }
    }
        public List<Crime> getCrimes() {
    //        return mCrimes;
            return  new ArrayList<>();
        }
        public Crime getCrime(UUID id) {
    //        for (Crime crime : mCrimes) {
    //            if (crime.getId().equals(id)) {
    //                return crime;
    //            }
    //        }
            return null;
        }

        public  static ContentValues  getContentValues(Crime crime) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(CrimeSchema.CrimeTable.Cols.UUID , crime.getId().toString());
            contentValues.put(CrimeSchema.CrimeTable.Cols.TITLE, crime.getTitle().toString());
            contentValues.put(CrimeSchema.CrimeTable.Cols.DATE , crime.getDate().toString());
            contentValues.put(CrimeSchema.CrimeTable.Cols.SOLVED , crime.isSolved() ? 1 : 0);



            return  contentValues;
        }

        public  void addCrime (Crime c) {
    //        mCrimes.add(c);

            ContentValues values = getContentValues(c);
            sqLiteDatabase.insert(CrimeSchema.CrimeTable.NAME , null , values);


        }


        public  void updateCrime (Crime c) {
            //        mCrimes.add(c);

            String crimeId = c.getId().toString();
            ContentValues values = getContentValues(c);
            sqLiteDatabase.update(CrimeSchema.CrimeTable.NAME , values ,
                    CrimeSchema.CrimeTable.Cols.UUID + "= ?" , new String[]{crimeId});
            
        }


}
