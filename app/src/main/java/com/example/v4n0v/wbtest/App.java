package com.example.v4n0v.wbtest;

import android.app.Application;
import timber.log.Timber;


public class App extends Application{
    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Timber.plant(new Timber.DebugTree());
    }
    public static App getInstance(){
        return instance;
    }
}
