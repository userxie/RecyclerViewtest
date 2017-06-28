package com.recyclerviewte.selfstudy.recyclerviewtest;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DemoAdapter mAdapter;
    int []colors={android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark,android.R.color.holo_orange_dark};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);

        final GridLayoutManager mGridLayoumanager = new GridLayoutManager(this,2);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
//                LinearLayoutManager.VERTICAL,false));
 //       mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mGridLayoumanager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type=mRecyclerView.getAdapter().getItemViewType(position);
                if(type==DataModel.TYPE_ONE){
                    return mGridLayoumanager.getSpanCount();
                }else{
                    return 1;
                }
            }
        });
        mRecyclerView.setLayoutManager(mGridLayoumanager);

        mAdapter=new DemoAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration(){
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams)view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top=20;
                outRect.bottom=20;
                if(spanSize!=mGridLayoumanager.getSpanCount()){
                    if(spanIndex==1){
                        outRect.left=10;
                    }else{
                        outRect.right=10;
                    }
                }
            }
        });
        initData();

    }

    private void initData() {
        List<DataModel> list=new ArrayList<DataModel>();

        for(int i=0;i<20;i++){
            int type = (int) ((Math.random()*3)+1);
            DataModel data=new DataModel();
            data.avatarColor = colors[type-1];
            data.type = type;
            data.name = "name"+i;
            data.content = "content : " + i;
            data.contentColor=colors[(type+1)%3];

            list.add(data);
        }
        mAdapter.addList(list);
        mAdapter.notifyDataSetChanged();
    }
}
