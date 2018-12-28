package com.zjh.dynamicviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class AutoFitHeightViewPager extends ViewPager {

    private final String TAG = AutoFitHeightViewPager.class.getSimpleName();
    private View mCurrentView;
    private int mCurrentPosition;
    private boolean isMeasureCallbackAllow = true;
    private HashMap<Integer, Integer> posHeightMap = new LinkedHashMap<>();
    private OnHeightChangeListener listener;

    public AutoFitHeightViewPager(Context context) {
        this(context, null);
    }

    public AutoFitHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mCurrentView == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        mCurrentView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        int height = mCurrentView.getMeasuredHeight();
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        posHeightMap.put(mCurrentPosition, mCurrentView.getMeasuredHeight());
        if (listener != null && isMeasureCallbackAllow) {
            listener.onHeightChange(mCurrentPosition, mCurrentView.getMeasuredHeight());
            isMeasureCallbackAllow = false;
        }
    }

    /**
     * 测量页面的高度
     *
     * @param position    页面位置
     * @param currentView
     */
    public void measureCurrentView(int position, View currentView) {
        mCurrentPosition = position;
        mCurrentView = currentView;
        requestLayout();
        isMeasureCallbackAllow = true;
    }

    /**
     * 测量页面的高度
     *
     * @param position    页面位置
     * @param currentFragment
     */
    public void measureCurrentView(int position, Fragment currentFragment) {
        mCurrentPosition = position;
        mCurrentView = currentFragment.getView();
        requestLayout();
        isMeasureCallbackAllow = true;
    }

    public int getHeight(int position) {
        return posHeightMap.get(position);
    }

    public void setOnHeightChangeListener(OnHeightChangeListener listener) {
        this.listener = listener;
    }

    interface OnHeightChangeListener {
        void onHeightChange(int position, int currentHeight);
    }

}