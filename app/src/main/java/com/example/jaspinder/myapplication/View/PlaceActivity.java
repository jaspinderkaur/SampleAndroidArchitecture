package com.example.jaspinder.myapplication.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.jaspinder.myapplication.R;
import com.example.jaspinder.myapplication.entity.Place;
import com.example.jaspinder.myapplication.entity.PlaceList;
import com.example.jaspinder.myapplication.presenter.PlaceListPresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;


public class PlaceActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @Inject
  PlaceAdapter mAdapter;

  @Inject
  PlaceListPresenter mPresenter;

  //HEAD: Declare UI elements
  private Toolbar mToolbar;
  private RecyclerView mRecyclerView;

  //HEAD: declare variables
  private List<Place> mDataSet;

  private Subscription mViewModelSubscription;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setUpToolBar();
    setUpDrawer();
    setUpUI();
    setDataAdapter();
  }

  /**
   * set up toolbar
   */
  private void setUpToolBar() {
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(mToolbar);
  }

  /**
   * Set up navigation drawer
   */
  private void setUpDrawer() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
  }

  /**
   * set up Recyclerview and ui elements
   */
  private void setUpUI() {
    mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    LinearLayoutManager linearlayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(linearlayoutManager);
  }

  /**
   * set up data adapter
   */
  private void setDataAdapter() {
    mAdapter = new PlaceAdapter(this, mDataSet);
  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  protected void onResume() {
    super.onResume();
    mViewModelSubscription = mPresenter.onResume(new Action1<PlaceList>() {
      @Override
      public void call(PlaceList viewModel) {
        final List<Place> places = viewModel.getPlaceList();
        mAdapter.setPlaces(places);
        mAdapter.notifyDataSetChanged();
      }
    });
  }

  /**
   * set up navigation drawer
   *
   * @param item
   * @return
   */
  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    // Handle navigation view item clicks here.
    switch (item.getItemId()) {
      case R.id.nav_news:

        break;
      case R.id.nav_events:
        break;
      case R.id.nav_places:
        break;
    }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }
}
