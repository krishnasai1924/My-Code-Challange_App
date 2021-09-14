package com.example.mycodetask.dagger;



import com.example.mycodetask.interfaces.EventMainInterface;
import com.example.mycodetask.presenter.EventPresenter;
import com.example.mycodetask.views.EventDetails;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DetailsActivityModule {

    @Binds
    abstract EventMainInterface.view provideMainView(EventDetails eventDetails);
    @Binds
    abstract  EventMainInterface.presenter provideMainPresenter(EventPresenter mainPresenter);

}
