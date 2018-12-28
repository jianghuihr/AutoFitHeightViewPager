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

public class PageFragment extends Fragment {

    private static final String EXTRA_DETAIL_NUM = "com.zjh.dynamicviewpager.extraDetailNum";

    private Context mContext;
    private RecyclerView mPageRecycler;
    private PageRecyclerAdapter mPageRecyclerAdapter;

    private int mDetailNum = 0;
    private List<String> mDetailList = new ArrayList<>();

    public static PageFragment newInstance(int detailNum) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_DETAIL_NUM, detailNum);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity().getApplicationContext();

        Bundle bundle = getArguments();
        if (bundle != null) {
            mDetailNum = bundle.getInt(EXTRA_DETAIL_NUM, 0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, null);
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
        for(int i = 0; i < mDetailNum; i++) {
            mDetailList.add("detail_" + i);
        }
        mPageRecyclerAdapter.refresh(mDetailList);
    }
}
