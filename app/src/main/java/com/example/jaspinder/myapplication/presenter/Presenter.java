package com.example.jaspinder.myapplication.presenter;

import android.os.Bundle;

import com.example.jaspinder.myapplication.entity.Place;

import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

public interface Presenter {
    public void onCreate(Bundle savedInstanceState);
    public Subscription onResume(Action1 loadAction);
    public void onPause(Bundle savedInstanceState);
}
