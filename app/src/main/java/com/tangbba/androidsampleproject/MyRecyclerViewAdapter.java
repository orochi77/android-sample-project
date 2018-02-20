package com.tangbba.androidsampleproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tangbba.androidsampleproject.model.Product;

import java.util.List;

/**
 * Created by orochi77 on 2018-02-19.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<Product> mDataProvider;

    public MyRecyclerViewAdapter(Context context, List<Product> dataProvider) {
        mContext = context;
        mDataProvider = dataProvider;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.setProduct(mDataProvider.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataProvider.size();
    }

    public List<Product> getDataProvider() {
        return mDataProvider;
    }

    public void setDataProvider(List<Product> dataProvider) {
        mDataProvider = dataProvider;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mLabelView;

        private Product mProduct;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.image_view);
            mLabelView = (TextView) itemView.findViewById(R.id.text_view);
        }

        public Product getProduct() {
            return mProduct;
        }

        public void setProduct(Product product) {
            mProduct = product;
            Picasso.with(mContext).load(product.getImageUrl()).into(mImageView);
            mLabelView.setText(product.getName());
        }
    }
}
