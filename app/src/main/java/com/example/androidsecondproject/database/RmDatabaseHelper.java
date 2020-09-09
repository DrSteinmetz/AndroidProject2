package com.example.androidsecondproject.database;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.androidsecondproject.model.Profile;

import java.util.List;

public class RmDatabaseHelper {

    private  ProfileDao profileDao;

    public RmDatabaseHelper(Context context){
        RmDatabase database = RmDatabase.getInstance(context);
        profileDao = database.getProfileDao();
    }

    public MutableLiveData<List<Profile>> getAllProfiles() {
        return profileDao.getAllProfiles();
    }

    public MutableLiveData<Profile> getProfile(int uid){
        return profileDao.getProfile(uid);
    }

    public void insertProfiles(List<Profile> profiles){
        profileDao.Insert(profiles);
    }

    public void insertProfile(Profile profile){
        profileDao.Insert(profile);
    }

    public void deleteProfile(Profile profile){
        profileDao.Delete(profile);
    }

    public void updateProfile(Profile profile){
        profileDao.Update(profile);
    }

}
