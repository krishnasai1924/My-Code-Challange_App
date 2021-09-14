package com.example.mycodetask.dagger;


import com.example.mycodetask.views.EventDetails;
import com.example.mycodetask.views.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
   @ContributesAndroidInjector(
            modules = {MainActivityModule.class}
    )
    abstract MainActivity contributeMainAcitivity();

    @ContributesAndroidInjector(
            modules = {DetailsActivityModule.class}
    )
    abstract EventDetails contributedetailsAcitivity();
}
