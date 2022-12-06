package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(ModelClass model);

    @Update
    void update(ModelClass model);

    @Delete
    void delete(ModelClass model);

    @Query("DELETE FROM model")
    void deleteAllData();

    @Query("SELECT * FROM model ORDER BY id DESC")
    LiveData<List<ModelClass>> getAllData();
}