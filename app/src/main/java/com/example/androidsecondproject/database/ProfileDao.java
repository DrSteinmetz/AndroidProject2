package com.example.androidsecondproject.database;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androidsecondproject.model.Profile;

import java.util.List;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM profile")
    MutableLiveData<List<Profile>> getAllProfiles();

    @Query("SELECT * FROM profile WHERE uid = :uid")
    MutableLiveData<Profile> getProfile(int uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(List<Profile> profiles);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(Profile profile);

    @Delete
    void Delete(Profile profile);

    @Update
    void Update(Profile profile);

}
