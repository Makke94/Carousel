package com.example.marwe497.carousel;

public class ListItem {

    private int imgDrawable;

    private String text;

    public ListItem(int imgDrawable, String text) {
        this.imgDrawable = imgDrawable;
        this.text = text;
    }

    public int getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(int imgDrawable) {
        this.imgDrawable = imgDrawable;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
