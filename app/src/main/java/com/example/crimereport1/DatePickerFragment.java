package com.example.crimereport1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class DatePickerFragment extends DialogFragment {

    public static final  String EXTRA_DATE = "hahaDate";
private DatePicker datePicker;
    private static  final  String  key_date = "date";
    public static DatePickerFragment newInstance(Date date) {

        Bundle args = new Bundle();
        args.putSerializable(key_date,date);

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

         View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date,null);

         Date date = (Date) getArguments().getSerializable(key_date);

         datePicker =  (DatePicker) view.findViewById(R.id.dialog_date_picker);
        Calendar calendar = Calendar.getInstance();

         int year = calendar.YEAR;
         int month = calendar.MONTH;
         int day = calendar.DAY_OF_MONTH;
        calendar.setTime(date);

        datePicker.init(year,month,day,null);


       return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.date_picket_title)
                .setView(view)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int day = datePicker.getDayOfMonth();
                        int month = datePicker.getMonth();
                        int year = datePicker.getYear();

                        Date date = new GregorianCalendar(year,month,day).getTime();

                        sendResult(Activity.RESULT_OK,date);
                    }
                })
                .create();

    }

    private void sendResult(int resultOk, Date date) {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE,date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK,intent);

    }
}
