package com.example.mycodetask.interfaces;

import com.example.mycodetask.modelclasses.Event;


public interface EventMainInterface {
    interface view{

        void loadEventData(Event eventList);
    }
    interface presenter{
        void getEventData(String eventid);
    }
}
