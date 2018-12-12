package com.example.marwe497.carousel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class CircularScrollView extends ScrollView {

    public CircularScrollView(Context context) {
        super(context);
    }

    public CircularScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircularScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){
        this.setOnScrollChangeListener(new OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                //TODO Fixa vad som händer när man scroll (Flytta views till början eller slutet)
            }
        });
    }
}
