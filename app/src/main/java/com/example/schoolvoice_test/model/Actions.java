package com.example.schoolvoice_test.model;


import com.example.schoolvoice_test.db.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;

public class Actions {

    @DatabaseField(generatedId = true, columnName = "id")
    public int id;
    @DatabaseField(columnName = "name")
    public String name;
    @DatabaseField(columnName = "image")
    public String image;
    @DatabaseField(columnName = "time")
    public String time;
    @DatabaseField(columnName = "isLiked")
    public  boolean isLiked;

    public Actions() {

    }

    public Actions(String name, String image, String time, boolean isLiked) {
        this.name = name;
        this.image = image;
        this.time = time;
        this.isLiked = isLiked;
    }




}
