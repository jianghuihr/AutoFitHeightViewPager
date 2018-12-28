package com.zjh.dynamicviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PageRecyclerAdapter extends RecyclerView.Adapter<PageRecyclerAdapter.PageRecyclerViewHolder> {

    private Context mContext;
    private List<String> mDetailList = new ArrayList<>();

    public PageRecyclerAdapter(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @NonNull
    @Override
    public PageRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item_page, viewGroup, false);
        return new PageRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PageRecyclerViewHolder pageRecyclerViewHolder, int i) {
        String detail = mDetailList.get(i);
        pageRecyclerViewHolder.mPageTV.setText(detail);
    }

    @Override
    public int getItemCount() {
        return mDetailList.size();
    }

    class PageRecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView mPageTV;

        public PageRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mPageTV = itemView.findViewById(R.id.tv_page);
        }
    }

    public void refresh(List<String> detailList) {
        mDetailList.clear();
        mDetailList.addAll(detailList);
        notifyDataSetChanged();
    }

}
