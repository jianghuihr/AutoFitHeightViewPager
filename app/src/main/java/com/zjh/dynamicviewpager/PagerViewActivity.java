package com.zjh.dynamicviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PagerViewActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private AutoFitHeightViewPager mViewPager;
    private AutoFitPagerAdapter mPagerAdapter;

    private List<PagerView> mPageViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.pager);
        mPagerAdapter = new AutoFitPagerAdapter();
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mViewPager.measureCurrentView(i, mPageViewList.get(i).getView());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < 4; i++) {
            PagerView pagerView = new PagerView("pager_" + i, new PageView((i + 1) % 5 + i * 2).getView(PagerViewActivity.this));
            mPageViewList.add(pagerView);
        }
        mViewPager.measureCurrentView(0, mPageViewList.get(0).getView());

        mPagerAdapter.refresh(mPageViewList);
    }
}
