package com.example.crimereport1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;

//public class CrimeActivity extends AppCompatActivity {
public class CrimeActivity extends SingleFragmentActivity {

    public static   final  String EXTRA_CRIME_ID = "myCrimeId";

    public  static Intent newIntent(Context packageContext , UUID crimeId){
        Intent intent = new Intent(packageContext , CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID , crimeId);
        return  intent;
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
//        if(fragment == null){
//            fragment =  new CrimeFragment();
//
//            fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit();
//
//        }
//
//    }

    @Override
    protected Fragment createFragment() {

//        return new CrimeFragment();

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return   CrimeFragment.newInstance(crimeId);

    }


}
