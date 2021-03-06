package com.recyclerviewte.selfstudy.recyclerviewtest;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Muzhou on 6/22/2017.
 */
public class TypeThreeViewHolder extends TypeAbstractViewHolder {
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;
    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        avatar= (ImageView) itemView.findViewById(R.id.avatar);
        name= (TextView) itemView.findViewById(R.id.name);
        contentImage= (ImageView) itemView.findViewById(R.id.contentImage);
        content= (TextView) itemView.findViewById(R.id.content);
        itemView.setBackgroundColor(Color.RED);
    }

    @Override
    public void bindHolder(DataModel model){
        avatar.setBackgroundResource(model.avatarColor);
        name.setText(model.name);
        content.setText(model.content);
        contentImage.setBackgroundResource(model.contentColor);
    }
}
