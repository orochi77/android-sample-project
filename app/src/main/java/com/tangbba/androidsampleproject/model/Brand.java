package com.tangbba.androidsampleproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by orochi77 on 2018-01-19.
 */

public class Brand implements Parcelable {

    @SerializedName("brandName")
    private String mBrandName;
    @SerializedName("categoryName")
    private String mCategoryName;
    @SerializedName("brandImageUrl")
    private String mBrandImageUrl;

    public Brand() {

    }

    public Brand(String brandName, String categoryName, String brandImageUrl) {
        mBrandName = brandName;
        mCategoryName = categoryName;
        mBrandImageUrl = brandImageUrl;
    }

    public String getBrandName() {
        return mBrandName;
    }

    public void setBrandName(String brandName) {
        mBrandName = brandName;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    public String getBrandImageUrl() {
        return mBrandImageUrl;
    }

    public void setBrandImageUrl(String brandImageUrl) {
        mBrandImageUrl = brandImageUrl;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "mBrandName='" + mBrandName + '\'' +
                ", mCategoryName='" + mCategoryName + '\'' +
                ", mBrandImageUrl='" + mBrandImageUrl + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mBrandName);
        dest.writeString(this.mCategoryName);
        dest.writeString(this.mBrandImageUrl);
    }

    protected Brand(Parcel in) {
        this.mBrandName = in.readString();
        this.mCategoryName = in.readString();
        this.mBrandImageUrl = in.readString();
    }

    public static final Parcelable.Creator<Brand> CREATOR = new Parcelable.Creator<Brand>() {
        @Override
        public Brand createFromParcel(Parcel source) {
            return new Brand(source);
        }

        @Override
        public Brand[] newArray(int size) {
            return new Brand[size];
        }
    };
}
