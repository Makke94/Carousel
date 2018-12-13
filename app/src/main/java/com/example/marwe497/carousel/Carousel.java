package com.example.marwe497.carousel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Carousel extends LinearLayout {

    private RecyclerView RecyclerView;
    private RecyclerView.Adapter Adapter;
    private RecyclerView.LayoutManager LayoutManager;
    private ArrayList<ListItem> itemList = new ArrayList<>();

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

    public void init(){

        RecyclerView = new RecyclerView(getContext());

        LayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.setLayoutManager(LayoutManager);

        Adapter = new CircularAdapter(itemList, getContext());
        RecyclerView.setAdapter(Adapter);

        RecyclerView.scrollToPosition(Integer.MAX_VALUE/2);

        this.addView(RecyclerView);
    }
}
