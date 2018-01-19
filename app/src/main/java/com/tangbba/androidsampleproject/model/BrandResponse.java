package com.tangbba.androidsampleproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orochi77 on 2018-01-19.
 */

public class BrandResponse implements Parcelable {

    @SerializedName("brands")
    private List<Brand> mBrands = new ArrayList<>();

    public BrandResponse() {
    }

    public BrandResponse(List<Brand> brands) {
        mBrands = brands;
    }

    public List<Brand> getBrands() {
        return mBrands;
    }

    public void setBrands(List<Brand> brands) {
        mBrands = brands;
    }

    @Override
    public String toString() {
        return "BrandResponse{" +
                "mBrands=" + mBrands +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.mBrands);
    }

    protected BrandResponse(Parcel in) {
        this.mBrands = in.createTypedArrayList(Brand.CREATOR);
    }

    public static final Parcelable.Creator<BrandResponse> CREATOR = new Parcelable.Creator<BrandResponse>() {
        @Override
        public BrandResponse createFromParcel(Parcel source) {
            return new BrandResponse(source);
        }

        @Override
        public BrandResponse[] newArray(int size) {
            return new BrandResponse[size];
        }
    };
}
