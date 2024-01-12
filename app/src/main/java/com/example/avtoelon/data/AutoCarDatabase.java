package com.example.avtoelon.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.avtoelon.model.AutoCar;

@Database(entities = {AutoCar.class}, version = 1)
public abstract class AutoCarDatabase extends RoomDatabase {

    public abstract AutoCarDao getAutoCarDao();
}
