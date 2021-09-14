package com.example.mycodetask.interfaces;

import com.example.mycodetask.modelclasses.Event;

import java.util.List;

public interface MainView {
    interface view{

        void loadData(List<Event> eventList);
    }
    interface presenter{
        void getData();
        void getSearchData( String searchItem);
    }

}
