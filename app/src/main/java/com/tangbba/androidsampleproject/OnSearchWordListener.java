package com.tangbba.androidsampleproject;

import com.tangbba.androidsampleproject.model.Brand;

import java.util.List;

/**
 * Created by orochi77 on 2018-01-19.
 */

public interface OnSearchWordListener {

    void filterBrandList(List<Brand> brandList);
    void changedSearchWord(String searchWord);
}
