package com.example.marwe497.carousel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class Carousel extends LinearLayout {

    private RecyclerView RecyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    private ArrayList<ListItem> itemList = new ArrayList<>();
    private SeekBar bar = new SeekBar(getContext());

    public Carousel(Context context) {
        super(context);
        init();
    }

    public Carousel(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Carousel(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Carousel(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void addItem(ListItem item){
        itemList.add(item);
        Adapter.notifyDataSetChanged();
    }

    public void setImgDimension(int width, int height){
        R.dimen.img_height = height;
    }

    public void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        RecyclerView = new RecyclerView(getContext());

        LayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.setLayoutManager(LayoutManager);

        Adapter = new CircularAdapter(itemList, getContext());
        RecyclerView.setAdapter(Adapter);

        RecyclerView.scrollToPosition(Integer.MAX_VALUE/2);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        RecyclerView.setLayoutParams(lp);

        RecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull android.support.v7.widget.RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //int firstPos = ((LinearLayoutManager)LayoutManager).findFirstVisibleItemPosition();

                int lastPos = ((LinearLayoutManager)LayoutManager).findLastVisibleItemPosition() - 1;

                lastPos = Math.abs(lastPos);

                lastPos = lastPos%((CircularAdapter)recyclerView.getAdapter()).getTrueLength();
                lastPos *= 100;

                lastPos /= ((CircularAdapter)recyclerView.getAdapter()).getTrueLength();
                bar.setProgress(lastPos, false);


            }
        });
        bar.setClickable(false);
        bar.getThumb().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
        //bar.animate();

        bar.setProgressTintList(ColorStateList.valueOf(Color.TRANSPARENT));

        this.addView(RecyclerView);
        this.addView(bar);
    }
}
