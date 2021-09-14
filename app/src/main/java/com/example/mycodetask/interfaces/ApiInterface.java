package com.example.mycodetask.interfaces;

import com.example.mycodetask.modelclasses.Event;
import com.example.mycodetask.modelclasses.ProductDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface ApiInterface {
    @GET("events")
        Call<ProductDetails> getEvents(@Query("client_id") String client_id);
    @GET("events/{eventid}")
    Call<Event> getEvent(@Path("eventid") String eventid, @Query("client_id") String client_id);

    @GET("events")
    Call<ProductDetails> getSearchEvents(@Query("client_id") String client_id, @Query("q") String q);


}
