package com.example.crimereport1;

import android.util.Log;

import  java.util.*;

public class Crime {
    private String title;
    private Date date;
    private  boolean solved;
    private UUID id;


    public Crime() {
        this(UUID.randomUUID());
        Log.i("ID" , UUID.randomUUID().toString());
//        date = new Date();

    }

    public  Crime(UUID idd) {
        id = idd;
        date = new Date();
       if(title == null) {
           title="";
       }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", solved=" + solved +
                ", id=" + id +
                '}';
    }
}

