package com.example.marwe497.carousel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChildItem extends LinearLayout {
    public ChildItem(Context context) {
        super(context);
    }

    public ChildItem(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public ChildItem(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ChildItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public ChildItem(Context context, ImageView imgView, String text) {
        super(context);
        initViews(imgView, text);
    }

    public ChildItem(Context context,  AttributeSet attrs , ImageView imgView, String text) {
        super(context, attrs);
        initViews(imgView, text);
    }

    public ChildItem(Context context,  AttributeSet attrs, int defStyleAttr , ImageView imgView, String text) {
        super(context, attrs, defStyleAttr);
        initViews(imgView, text);
    }

    public ChildItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes , ImageView imgView, String text) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews(imgView, text);
    }


    private ImageView imageView;

    private TextView txtView;

    private void initViews(ImageView imgView, String text){
        this.setOrientation(LinearLayout.VERTICAL);
        this.setGravity(Gravity.CENTER_HORIZONTAL);
        imageView = imgView;
        txtView = new TextView(getContext());
        txtView.setText(text);

        imageView.setForegroundGravity(Gravity.CENTER_HORIZONTAL);
        txtView.setGravity(Gravity.CENTER_HORIZONTAL);

        this.addView(imgView);
        this.addView(txtView);
    }

}
