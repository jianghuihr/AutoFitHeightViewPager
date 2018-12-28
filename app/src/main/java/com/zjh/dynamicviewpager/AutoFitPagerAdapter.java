package com.zjh.dynamicviewpager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AutoFitPagerAdapter extends PagerAdapter {

    private List<PagerView> mPaeViewList = new ArrayList<>();

    public AutoFitPagerAdapter() {
    }

    @Override
    public int getCount() {
        return mPaeViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        PagerView pageView = mPaeViewList.get(position);
        container.addView(pageView.getView());
        return pageView.getView();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        PagerView pageView = mPaeViewList.get(position);
        return pageView== null ? super.getPageTitle(position) : pageView.getTitle();
    }

    public void refresh(List<PagerView> pageViewList) {
        mPaeViewList.clear();
        mPaeViewList.addAll(pageViewList);
        notifyDataSetChanged();
    }
}
