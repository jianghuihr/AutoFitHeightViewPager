package com.zjh.dynamicviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class PageView {


    private Context mContext;
    private RecyclerView mPageRecycler;
    private PageRecyclerAdapter mPageRecyclerAdapter;

    private int mDetailNum = 0;
    private List<String> mDetailList = new ArrayList<>();


    public PageView(int detailNum) {
        this.mDetailNum = detailNum;
    }

    public View getView(Context context) {
        this.mContext = context.getApplicationContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_page, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mPageRecycler = view.findViewById(R.id.recycler_page);
        mPageRecycler.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mPageRecycler.addItemDecoration(new DividerItemDecoration(mContext, LinearLayout.VERTICAL));

        mPageRecyclerAdapter = new PageRecyclerAdapter(mContext);
        mPageRecycler.setAdapter(mPageRecyclerAdapter);
        mDetailList.clear();
        for (int i = 0; i < mDetailNum; i++) {
            mDetailList.add("detail_" + i);
        }
        mPageRecyclerAdapter.refresh(mDetailList);
    }
}
