package com.zjh.dynamicviewpager;

import android.support.v4.app.Fragment;

public class PagerFragment {
    private String title;
    private Fragment fragment;

    public PagerFragment(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
