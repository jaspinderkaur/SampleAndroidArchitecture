package com.example.jaspinder.myapplication.interactor;

import com.example.jaspinder.myapplication.entity.Place;

import java.util.List;
import java.util.Observable;

public interface Interactor {
    public rx.Observable<List<Place>> getPlaceListData();
}
