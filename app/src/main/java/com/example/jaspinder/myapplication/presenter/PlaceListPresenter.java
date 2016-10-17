package com.example.jaspinder.myapplication.presenter;

import android.os.Bundle;
import android.util.Log;

import com.example.jaspinder.myapplication.entity.Place;
import com.example.jaspinder.myapplication.entity.PlaceList;
import com.example.jaspinder.myapplication.interactor.PlaceListInteractor;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class PlaceListPresenter implements Presenter {

  PlaceListInteractor mInteractor;

  PlaceList mViewModel;
  BehaviorSubject<PlaceList> mViewModelSubject = BehaviorSubject.create();

  public PlaceListPresenter(PlaceListInteractor interactor) {
    mInteractor = interactor;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {

  }

  @Override
  public Subscription onResume(Action1 loadAction) {
    if (mViewModel != null) {
      mViewModelSubject.onNext(mViewModel);
    } else {
      refresh();
    }
    return mViewModelSubject
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(loadAction);
  }

  @Override
  public void onPause(Bundle savedInstanceState) {
    savedInstanceState.putParcelable(Place.class.getSimpleName(), mViewModel);
  }

  private void refresh() {
    mInteractor.getPlaceListData()
        .subscribe(new Action1<List<Place>>() {
          @Override
          public void call(List<Place> place) {
            mViewModelSubject.onNext(mViewModel);
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {
            Log.e("CatalogPresenter", "Error while getting data", throwable);
          }
        });
  }
}
