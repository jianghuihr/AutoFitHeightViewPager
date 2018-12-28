package com.zjh.dynamicviewpager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PagerFragmentActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private AutoFitHeightViewPager mViewPager;
    private AutoFitFragmentPagerAdapter mFragmentPagerAdapter;

    private List<PagerFragment> mPageFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.pager);
        mFragmentPagerAdapter = new AutoFitFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mViewPager.measureCurrentView(i, mPageFragmentList.get(i).getFragment());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < 4; i++) {
            PagerFragment pagerFragment = new PagerFragment("pager_" + i, PageFragment.newInstance((i + 1) % 5 + i * 2));
            mPageFragmentList.add(pagerFragment);
        }
        mViewPager.measureCurrentView(0, mPageFragmentList.get(0).getFragment());

        mFragmentPagerAdapter.refresh(mPageFragmentList);
    }
}
