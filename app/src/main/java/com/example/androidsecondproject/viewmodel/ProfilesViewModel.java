package com.example.androidsecondproject.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.androidsecondproject.database.RmDatabaseHelper;
import com.example.androidsecondproject.model.Profile;

import java.util.List;

public class ProfilesViewModel extends AndroidViewModel {

    private MutableLiveData<List<Profile>> profiles;
    private RmDatabaseHelper helper;

    public ProfilesViewModel(@NonNull Application application) {
        super(application);

        helper = new RmDatabaseHelper(application.getApplicationContext());
    }

    MutableLiveData<List<Profile>> getProfiles(){
        if(profiles == null){
            profiles = helper.getAllProfiles();
        }
        return profiles;
    }



}
