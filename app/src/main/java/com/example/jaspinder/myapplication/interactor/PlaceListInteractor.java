package com.example.jaspinder.myapplication.interactor;


import com.example.jaspinder.myapplication.entity.Place;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class PlaceListInteractor implements Interactor {


  @Override
  public Observable<List<Place>> getPlaceListData() {
    Observable<List<Place>> placeListObservable = Observable.just(getPlacesList());
    return placeListObservable;
  }

  private List<Place> getPlacesList() {
    List<Place> placeList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      placeList.add(new Place(i, "Place " + i));
    }
    return placeList;
  }
}
