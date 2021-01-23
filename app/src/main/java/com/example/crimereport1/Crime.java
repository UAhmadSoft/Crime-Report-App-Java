package com.example.crimereport1;

import  java.util.*;

public class Crime {
    private String title;
    private Date date;
    private  boolean solved;
    private UUID id;


    public Crime() {
        this(UUID.randomUUID());
//        date = new Date();

    }

    public  Crime(UUID id) {
        id = id;
        date = new Date();
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
}

