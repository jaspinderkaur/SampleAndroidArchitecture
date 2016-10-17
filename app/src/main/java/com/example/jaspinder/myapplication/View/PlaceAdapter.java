package com.example.jaspinder.myapplication.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaspinder.myapplication.R;
import com.example.jaspinder.myapplication.entity.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaspinder on 16/10/16.
 */

public class PlaceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private Context mContext;
  private List<Place> mDataSet = new ArrayList<>();

  public PlaceAdapter(@NonNull Context context) {
    this.mContext = context;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder viewHolder;
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.place_list_item, parent, false);
    viewHolder = new ItemViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
    itemViewHolder.mTitle.setText(mDataSet.get(position).getName());
  }

  public void setPlaces(List<Place> places) {
    this.mDataSet = places;
  }

  public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView mTitle;

    public ItemViewHolder(View itemView) {
      super(itemView);
      mTitle = (TextView) itemView.findViewById(R.id.tvTitle);
    }
  }

  /**
   * Returns the item count based on the data source list count.
   *
   * @return number of items in the data source list
   */
  @Override
  public int getItemCount() {
    return mDataSet.size();
  }

  /**
   * dialog options onClick interface.
   */
  public interface OnItemClickListener {
    void onItemClick(int menuOptionId);
  }

}
