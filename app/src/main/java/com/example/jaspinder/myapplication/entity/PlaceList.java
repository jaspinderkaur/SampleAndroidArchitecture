package com.example.jaspinder.myapplication.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Jaspinder on 17/10/16.
 */

public class PlaceList implements Parcelable{
  private List<Place> placeList;

  public PlaceList(List<Place> places) {
    this.placeList = places;
  }

  protected PlaceList(Parcel in) {
    placeList = in.createTypedArrayList(Place.CREATOR);
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(placeList);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<PlaceList> CREATOR = new Creator<PlaceList>() {
    @Override
    public PlaceList createFromParcel(Parcel in) {
      return new PlaceList(in);
    }

    @Override
    public PlaceList[] newArray(int size) {
      return new PlaceList[size];
    }
  };

  public List<Place> getPlaceList() {
    return placeList;
  }

  public void setPlaceList(List<Place> placeList) {
    this.placeList = placeList;
  }
}
