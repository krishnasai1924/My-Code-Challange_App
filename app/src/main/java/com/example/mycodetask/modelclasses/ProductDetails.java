package com.example.mycodetask.modelclasses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public  class ProductDetails {
    @SerializedName("events")
        @Expose
        private final List<Event> events = null;

        public List<Event> getEvents() {
            return events;
        }





}



