package com.example.jaspinder.myapplication.entity;

import android.os.Parcel;
import android.os.Parcelable;

import auto.parcel.AutoParcel;

/**
 * Created by Jaspinder on 16/10/16.
 */
@AutoParcel
public class Place implements Parcelable {
  private int id;
  private String name;

  public Place(int id, String name) {
    this.id = id;
    this.name = name;
  }

  protected Place(Parcel in) {
    id = in.readInt();
    name = in.readString();
  }

  public static final Creator<Place> CREATOR = new Creator<Place>() {
    @Override
    public Place createFromParcel(Parcel in) {
      return new Place(in);
    }

    @Override
    public Place[] newArray(int size) {
      return new Place[size];
    }
  };

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(id);
    parcel.writeString(name);
  }
}
