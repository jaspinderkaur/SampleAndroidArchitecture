package com.example.jaspinder.myapplication;

import com.example.jaspinder.myapplication.View.PlaceActivity;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class,modules = {PlaceModule.class})
public interface PlaceComponent {
  void inject(PlaceActivity activity);
}
