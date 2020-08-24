package com.example.hdesign.ui.room;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.hdesign.ui.ImageRV;

import java.util.List;

@Dao
public interface ImageDao {
    @Query("SELECT * FROM imageRV")
    List<ImageRV> getAll();

    @Query("SELECT * FROM imageRV")
    LiveData<List<ImageRV>> getAllLive();

    @Insert
    void insert (ImageRV imageRV);

    @Update
    void update (ImageRV imageRV);

    @Delete
    void delete(ImageRV imageRV);
}
