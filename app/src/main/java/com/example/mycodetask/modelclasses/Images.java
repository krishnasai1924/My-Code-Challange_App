package com.example.mycodetask.modelclasses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("huge")
    @Expose
    private final String huge;

    public Images(String huge) {
        this.huge = huge;
    }

    public String getHuge() {
        return huge;
    }



}




