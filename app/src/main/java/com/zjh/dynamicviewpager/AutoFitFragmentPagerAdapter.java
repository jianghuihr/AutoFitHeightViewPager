package com.zjh.dynamicviewpager;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class AutoFitFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<PagerFragment> mFragmentList = new ArrayList<>();

    public AutoFitFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i).getFragment();
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        PagerFragment pagerFragment = mFragmentList.get(position);
        return pagerFragment == null ? super.getPageTitle(position) : pagerFragment.getTitle();
    }

    public void refresh(List<PagerFragment> pagerFragmentList) {
        mFragmentList.clear();
        mFragmentList.addAll(pagerFragmentList);
        notifyDataSetChanged();
    }
}
