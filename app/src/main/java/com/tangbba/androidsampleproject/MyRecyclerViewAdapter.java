package com.tangbba.androidsampleproject;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tangbba.androidsampleproject.util.DrawableUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orochi77 on 2018-02-22.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mDataProvider = new ArrayList<>();

    public MyRecyclerViewAdapter(Context context, List<String> dataProvider) {
        mContext = context;
        mDataProvider = dataProvider;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.textView.setText(String.valueOf(position));
        if (position == 1) {
            ViewCompat.setBackground(viewHolder.iconView, DrawableUtil.setTintColorWithMutate(mContext, R.drawable.ic_android_black_24dp, R.color.colorAccent));
        }
    }

    @Override
    public int getItemCount() {
        return mDataProvider.size();
    }

    public void addItem() {
        String label  = "";
        mDataProvider.add(label);
        notifyItemInserted(mDataProvider.size() - 1);
    }

    public List<String> getDataProvider() {
        return mDataProvider;
    }

    public void setDataProvider(List<String> dataProvider) {
        mDataProvider = dataProvider;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View iconView;
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            iconView = itemView.findViewById(R.id.icon_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
