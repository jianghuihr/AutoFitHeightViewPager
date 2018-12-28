package com.zjh.dynamicviewpager;

import android.view.View;

public class PagerView {
    private String title;
    private View view;

    public PagerView(String title, View view) {
        this.title = title;
        this.view = view;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
