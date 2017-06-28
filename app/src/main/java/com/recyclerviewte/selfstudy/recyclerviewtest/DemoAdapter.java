package com.recyclerviewte.selfstudy.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muzhou on 6/21/2017.
 */
public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mLayoutInflater;

    private List<DataModel> mList = new ArrayList<>();
    public DemoAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModel> list){
        mList.addAll(list);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one,parent,false));
            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two,parent,false));
            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((TypeAbstractViewHolder)holder).bindHolder(mList.get(position));
      /*  int viewType = getItemViewType(position);
        switch (viewType){
            case DataModel.TYPE_ONE:
                ((TypeOneViewHolder)holder).bindHolder(mList.get(position));
                break;
            case DataModel.TYPE_TWO:
                ((TypeTwoViewHolder)holder).bindHolder(mList.get(position));
                break;
            case DataModel.TYPE_THREE:
                ((TypeThreeViewHolder)holder).bindHolder(mList.get(position));
                break;
        }
        */
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).type;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
