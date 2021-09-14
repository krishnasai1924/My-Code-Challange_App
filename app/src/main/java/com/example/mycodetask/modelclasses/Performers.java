package com.example.mycodetask.modelclasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Performers {

    public Performers( Images images) {
        this.images = images;
    }

    public Images getImages() {
        return images;
    }



    @SerializedName("images")
    @Expose
    private final Images images;












}
