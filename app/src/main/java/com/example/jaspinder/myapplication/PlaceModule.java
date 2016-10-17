package com.example.jaspinder.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.example.jaspinder.myapplication.View.PlaceAdapter;
import com.example.jaspinder.myapplication.interactor.PlaceListInteractor;
import com.example.jaspinder.myapplication.presenter.PlaceListPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class PlaceModule {
    private final AppCompatActivity activity;

    public PlaceModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides @Named("activity")
    Context provideActivityContext() {
        return activity;
    }

    @Provides
    PlaceListPresenter providePresenter(PlaceListInteractor interactor) {
        return new PlaceListPresenter(interactor);
    }

    @Provides
    PlaceListInteractor provideInteractor() {
        return new PlaceListInteractor();
    }

    @Provides
    LayoutInflater provideLayoutInflater() {
        return activity.getLayoutInflater();
    }

    @Provides
    PlaceAdapter provideCatalogAdapter() {
        return new PlaceAdapter(activity);
    }

}
