package com.example.mycodetask.presenter;

import android.util.Log;

import com.example.mycodetask.interfaces.MainView;
import com.example.mycodetask.interfaces.ApiInterface;
import com.example.mycodetask.interfaces.ApiClient;
import com.example.mycodetask.modelclasses.Event;
import com.example.mycodetask.modelclasses.ProductDetails;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;

public class MainPresenter implements MainView.presenter {
    @Inject MainView.view view;
    String client_id="MjI5NDE1NTR8MTYyOTE3ODIzNC4xOTgxNDEz";
    @Inject
   public MainPresenter(){

    }

    @Override
    public void getData() {
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<ProductDetails> call=apiInterface.getEvents(client_id);
        call.enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, retrofit2.Response<ProductDetails> response) {

                if(response.isSuccessful()&& response.body()!=null) {

                        List<Event> data=response.body().getEvents();
                        view.loadData(data);
                }
            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {
                Log.d("error:",t.getMessage());
            }
        });

    }

    @Override
    public void getSearchData(String searchItem) {
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);

        Call<ProductDetails> call=apiInterface.getSearchEvents(client_id,searchItem);
        call.enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, retrofit2.Response<ProductDetails> response) {
                if(response.isSuccessful()&& response.body()!=null) {

                    List<Event> data=response.body().getEvents();

                    view.loadData(data);

                }
            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {
                Log.d("error:",t.getMessage());
            }
        });
    }

}
