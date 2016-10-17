package com.example.jaspinder.myapplication;

import android.app.Application;


public class DemoApplication extends Application {

    ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}
