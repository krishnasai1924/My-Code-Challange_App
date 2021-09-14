package com.example.mycodetask.modelclasses;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venue {

    @SerializedName("display_location")
    @Expose
    private final String displayLocation;

    public Venue(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

}

