package com.example.mycodetask.presenter;

import android.util.Log;

import com.example.mycodetask.interfaces.EventMainInterface;
import com.example.mycodetask.interfaces.ApiInterface;
import com.example.mycodetask.interfaces.ApiClient;
import com.example.mycodetask.modelclasses.Event;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;

public class EventPresenter implements EventMainInterface.presenter {
    @Inject
    EventMainInterface.view view;
    String client_id="MjI5NDE1NTR8MTYyOTE3ODIzNC4xOTgxNDEz";

    @Inject
    public EventPresenter(){

    }
    @Override
    public void getEventData(String id) {
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<Event> call=apiInterface.getEvent(id,client_id);
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, retrofit2.Response<Event> response) {

                if(response.isSuccessful()&& response.body()!=null) {

                    Event eventDetailsModel=  response.body();
                    view.loadEventData(eventDetailsModel);
                }

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                Log.d("error:",t.getMessage());
            }
        });


    }
}
