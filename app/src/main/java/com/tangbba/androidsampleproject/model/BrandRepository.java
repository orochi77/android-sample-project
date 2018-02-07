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
    private String mSelectedCategory = "전체";

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
                if (mSelectedCategory.equals("전체")) {
                    mOnSearchWordListener.filterBrandList(mAllBrandList);
                } else {
                    List<Brand> categoryFilteredBrandList = new ArrayList<>(Collections2.filter(mAllBrandList, new Predicate<Brand>() {
                        @Override
                        public boolean apply(Brand input) {
                            return input.getCategoryName().equals(mSelectedCategory);
                        }
                    }));
                    mOnSearchWordListener.filterBrandList(categoryFilteredBrandList);
                }
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

    public String getSelectedCategory() {
        return mSelectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        if (selectedCategory.equals(mSelectedCategory)) {
            return;
        }
        mSelectedCategory = selectedCategory;

        if (mSelectedCategory.equals("전체")) {
            mOnSearchWordListener.filterBrandList(mAllBrandList);
        } else {
            List<Brand> categoryFilteredBrandList = new ArrayList<>(Collections2.filter(mAllBrandList, new Predicate<Brand>() {
                @Override
                public boolean apply(Brand input) {
                    return input.getCategoryName().equals(mSelectedCategory);
                }
            }));
            mOnSearchWordListener.filterBrandList(categoryFilteredBrandList);
        }


    }
}
