package com.example.androidsecondproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.example.androidsecondproject.model.Profile;

@Database(entities = Profile.class,version = 1)
public abstract class RmDatabase extends androidx.room.RoomDatabase {

    private static final String DATABASE_NAME = "room_database.db";
    private static RmDatabase database;

    private RmDatabase(){}

    public static RmDatabase getInstance(Context context) {
            if(database == null){
                database = Room.databaseBuilder(context, RmDatabase.class,DATABASE_NAME).allowMainThreadQueries().build();
            }
            return database;
    }

    public abstract ProfileDao getProfileDao();
}
