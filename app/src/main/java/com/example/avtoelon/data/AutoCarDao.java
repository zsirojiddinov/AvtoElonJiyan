package com.example.avtoelon.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.avtoelon.model.AutoCar;

import java.util.List;

@Dao
public interface AutoCarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addAutoCar(AutoCar car);

    @Update
    public void updateAutoCar(AutoCar car);

    @Delete
    public void deleteAutoCar(AutoCar car);

    @Query("select * from autocar")
    public List<AutoCar> getAllAutoCar();

    @Query("select * from autocar where isLike==:isLikeValue")
    public List<AutoCar> getAllLikeAutoCar(boolean isLikeValue);

    @Query("select * from autocar where id==:autoCarId")
    public AutoCar getAutoCar(int autoCarId);
}
