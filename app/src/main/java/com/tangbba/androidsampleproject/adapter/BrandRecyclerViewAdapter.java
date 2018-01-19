package com.tangbba.androidsampleproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tangbba.androidsampleproject.OnSearchWordListener;
import com.tangbba.androidsampleproject.R;
import com.tangbba.androidsampleproject.model.Brand;
import com.tangbba.androidsampleproject.model.BrandRepository;

import java.util.List;

/**
 * Created by orochi77 on 2018-01-19.
 */

public class BrandRecyclerViewAdapter extends RecyclerView.Adapter<BrandRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "BrandRecyclerViewAdapter";

    private Context mContext;
    private List<Brand> mDataProvider;
    private BrandRepository mBrandRepository;

    private String mSearchWord = "";

    public BrandRecyclerViewAdapter(Context context, List<Brand> dataProvider, BrandRepository brandRepository) {
        mContext = context;
        mDataProvider = dataProvider;
        mBrandRepository = brandRepository;
        mBrandRepository.setOnSearchWordListener(mSearchWordListener);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Brand brand = getDataProvider().get(position);
        holder.setBrand(brand);
    }

    @Override
    public int getItemCount() {
        return getDataProvider().size();
    }

    public List<Brand> getDataProvider() {
        return mDataProvider;
    }

    public void setDataProvider(List<Brand> dataProvider) {
        mDataProvider = dataProvider;
        notifyDataSetChanged();
    }

    public String getSearchWord() {
        return mSearchWord;
    }

    public void setSearchWord(String searchWord) {
        mSearchWord = searchWord;
    }

    private OnSearchWordListener mSearchWordListener = new OnSearchWordListener() {
        @Override
        public void filterBrandList(List<Brand> brandList) {
            setDataProvider(brandList);
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        private Brand mBrand;
        private ImageView mBrandImageView;
        private TextView mBrandNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mBrandImageView = (ImageView) itemView.findViewById(R.id.brand_image_view);
            mBrandNameTextView = (TextView) itemView.findViewById(R.id.brand_name_text_view);
        }

        public Brand getBrand() {
            return mBrand;
        }

        public void setBrand(Brand brand) {
            mBrand = brand;
            mBrandNameTextView.setText(brand.getBrandName());
            Log.d("ViewHolder", brand.getBrandImageUrl());
            Picasso.with(mContext)
                    .load(mBrand.getBrandImageUrl())
                    .placeholder(R.drawable.place_holder_drawable)
                    .into(mBrandImageView);
        }
    }
}
