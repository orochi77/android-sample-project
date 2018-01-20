package com.tangbba.androidsampleproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tangbba.androidsampleproject.R;

import java.util.List;

/**
 * Created by orochi77 on 2018-01-20.
 */

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mDataProvider;
    private OnCategoryItemListener mOnCategoryItemListener;

    private String mSelectedCategoryName;

    public CategoryRecyclerViewAdapter(Context context, List<String> dataProvider) {
        mContext = context;
        mDataProvider = dataProvider;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataProvider.size();
    }

    public List<String> getDataProvider() {
        return mDataProvider;
    }

    public void setDataProvider(List<String> dataProvider) {
        mDataProvider = dataProvider;
    }

    public OnCategoryItemListener getOnCategoryItemListener() {
        return mOnCategoryItemListener;
    }

    public void setOnCategoryItemListener(OnCategoryItemListener onCategoryItemListener) {
        mOnCategoryItemListener = onCategoryItemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mCategoryNameTextView;
        private String mCategoryName;

        public ViewHolder(View itemView) {
            super(itemView);
            mCategoryNameTextView = (TextView) itemView.findViewById(R.id.category_name_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mCategoryName == null || mCategoryName.isEmpty()) {
                        return;
                    }

                    if (getOnCategoryItemListener() != null) {
                        getOnCategoryItemListener().onClickCategoryItem(mCategoryName);
                    }
                }
            });
        }

        public String getCategoryName() {
            return mCategoryName;
        }

        public void setCategoryName(String categoryName) {
            mCategoryName = categoryName;
        }
    }

    public interface OnCategoryItemListener {
        void onClickCategoryItem(String categoryName);
    }
}
