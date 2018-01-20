package com.tangbba.androidsampleproject.model;

import android.content.Context;
import android.util.Log;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.gson.Gson;
import com.tangbba.androidsampleproject.OnSearchWordListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orochi77 on 2018-01-19.
 */

public class BrandRepository {
    private static final String TAG = "BrandRepository";

    private Context mContext;
    private List<Brand> mAllBrandList = new ArrayList<>();
    private String mSearchWord = "";

    private OnSearchWordListener mOnSearchWordListener;

    public BrandRepository(Context context) {
        mContext = context;
    }

    public List<Brand> getAllBrandList() {
        return mAllBrandList;
    }

    public void setAllBrandList(List<Brand> allBrandList) {
        mAllBrandList = allBrandList;
        Log.d(TAG, new Gson().toJson(allBrandList));
    }

    public String getSearchWord() {
        return mSearchWord;
    }

    public void setSearchWord(String searchWord) {
        mSearchWord = searchWord;
        if (mOnSearchWordListener != null) {
            if (searchWord.isEmpty()) {
                mOnSearchWordListener.changedSearchWord("");
                mOnSearchWordListener.filterBrandList(mAllBrandList);
            } else {
                mOnSearchWordListener.changedSearchWord(mSearchWord);
                List<Brand> filteredBrandList = new ArrayList<>(Collections2.filter(mAllBrandList, new Predicate<Brand>() {
                    @Override
                    public boolean apply(Brand input) {
                        return input.getBrandName().toLowerCase().contains(mSearchWord.toLowerCase());
                    }
                }));
                mOnSearchWordListener.filterBrandList(filteredBrandList);
            }

        }
    }



    public OnSearchWordListener getOnSearchWordListener() {
        return mOnSearchWordListener;
    }

    public void setOnSearchWordListener(OnSearchWordListener onSearchWordListener) {
        mOnSearchWordListener = onSearchWordListener;
    }
}
