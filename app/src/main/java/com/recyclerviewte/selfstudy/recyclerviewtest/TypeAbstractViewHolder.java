package com.recyclerviewte.selfstudy.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Muzhou on 6/22/2017.
 */
public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bindHolder(DataModel model);
}
