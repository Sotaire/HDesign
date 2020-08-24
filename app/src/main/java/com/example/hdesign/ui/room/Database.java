package com.example.hdesign.ui.room;

import androidx.room.RoomDatabase;

import com.example.hdesign.ui.ImageRV;

@androidx.room.Database(entities = {ImageRV.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract ImageDao imageDao();
}
