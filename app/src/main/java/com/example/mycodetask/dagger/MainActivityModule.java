package com.example.mycodetask.dagger;


import com.example.mycodetask.interfaces.MainView;
import com.example.mycodetask.presenter.MainPresenter;
import com.example.mycodetask.views.MainActivity;

import dagger.Binds;
import dagger.Module;

@Module
public  abstract class MainActivityModule {

    @Binds
    abstract MainView.view provideMainView(MainActivity mainActivity);
   @Binds
    abstract  MainView.presenter provideMainPresenter(MainPresenter mainPresenter);

}
