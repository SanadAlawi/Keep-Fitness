package com.example.mainactivity;

import android.view.View;

import java.util.ArrayList;

public class Sport {
    private String Name;
    private String sportTime;
    private String Information;
    private int imagePath;

    public Sport(String Name, String bestTime, String Information, int imagePath){
        this.Name = Name;
        this.sportTime = bestTime;
        this.Information = Information;
        this.imagePath = imagePath;
    }

    public Sport(String Name, String bestTime, int imagePath){
        this.Name = Name;
        this.sportTime = bestTime;
        this.imagePath = imagePath;
    }

    public Sport(String Name, String bestTime, String Information){
        this.Name = Name;
        this.sportTime = bestTime;
        this.Information = Information;
    }

    public Sport(String Name, String bestTime){
        this.Name = Name;
        this.sportTime = bestTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSportTime() {
        return sportTime;
    }

    public void setSportTime(String sportTime) {
        this.sportTime = sportTime;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }
}
