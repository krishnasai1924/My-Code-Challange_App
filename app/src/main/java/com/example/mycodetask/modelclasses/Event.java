package com.example.mycodetask.modelclasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Event {
    public Event(Venue venue, Integer id, String announceDate, String title) {
        this.venue = venue;
        this.id = id;
        this.announceDate = announceDate;
        this.title = title;
    }

    public Venue getVenue() {
        return venue;
    }

    public List<Performers> getPerformers() {
        return performers;
    }

    @SerializedName("performers")
    @Expose
    private final List<Performers> performers = null;
    @SerializedName("venue")
    @Expose
    private final Venue venue;

        @SerializedName("id")
        @Expose
        private final Integer id;
        @SerializedName("announce_date")
        @Expose
        private final String announceDate;
        @SerializedName("title")
        @Expose
        private final String title;

        public Integer getId() {
            return id;
        }

        public String getAnnounceDate() {
            return announceDate;
        }

        public String getTitle() {
            return title;
        }


}


