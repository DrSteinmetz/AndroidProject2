package com.example.androidsecondproject.model;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Profile {

    @PrimaryKey
    private String uid;

    private String fullName;
    private Uri imageUri;
    private String description;
    private float age;
    private boolean gender; //men = true;

    public Profile() {
    }

    public Profile(String uid, String fullName, Uri imageUri, String description, float age, boolean gender) {
        this.uid = uid;
        this.fullName = fullName;
        this.imageUri = imageUri;
        this.description = description;
        this.age = age;
        this.gender = gender;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
