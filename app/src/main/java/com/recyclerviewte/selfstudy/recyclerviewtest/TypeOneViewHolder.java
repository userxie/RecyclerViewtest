package com.recyclerviewte.selfstudy.recyclerviewtest;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Muzhou on 6/22/2017.
 */
public class TypeOneViewHolder extends TypeAbstractViewHolder {
    public ImageView avatar;
    public TextView name;
    public TypeOneViewHolder(View itemView) {
        super(itemView);
        avatar= (ImageView) itemView.findViewById(R.id.avatar);
        name= (TextView) itemView.findViewById(R.id.name);

        itemView.setBackgroundColor(Color.BLUE);
    }

    @Override
    public void bindHolder(DataModel model){
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
    }

}
