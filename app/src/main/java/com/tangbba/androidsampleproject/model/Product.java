package com.tangbba.androidsampleproject.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by orochi77 on 2018-02-19.
 */

public class Product implements Parcelable {

    private String mName;
    private String mImageUrl;

    public Product() {
    }

    public Product(String name, String imageUrl) {
        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeString(this.mImageUrl);
    }

    protected Product(Parcel in) {
        this.mName = in.readString();
        this.mImageUrl = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("Voice Recorder", "https://lh3.googleusercontent.com/1es9PNr_xrxuKbstXyBAtWwCeC6d9raCs7ojUzuIjKK4tqhcvKXbIJrHBA0a7guWKg=w170-rw"));
        products.add(new Product("콘-카카오톡 테마", "https://lh3.googleusercontent.com/bYP4BCCU0Xru0W6n4h6FIVayrs6Q3dZuJ9OQIHCyBvmCLnm4t8s4p8hq-E4DFp5U0XgR=w170-rw"));
        products.add(new Product("런타스틱 슬립베터", "https://lh3.googleusercontent.com/uGWDAkPWuldPqxxDwMXQ9u9355DILXKMe_CD4rFFcm3uwlKwT7f3p2C-_hlKFGMQOrU=w170-rw"));
        products.add(new Product("다이닝코드", "https://lh3.googleusercontent.com/4sZdUDReLoNqUJ-qqEJ4GSQXb1MTlOBT4LrcmWR54Uxx-trR4VCeLmGipP4yMtY2XjZI=w170-rw"));
        products.add(new Product("현대백화점", "https://lh3.googleusercontent.com/9nWpRIYfg2A31C68yuZW0tq71tuZneQ2u0HjzmFzCM_ehNjIq8VjoAVYwyFZzF2ZzBsn=w170-rw"));
        products.add(new Product("CU Buy-Self", "https://lh3.googleusercontent.com/WHzazAU84kl0Vep8at1lVodwOHcS3LfsaiVNAMtP_BPlMW2OgjssvCF-EYg53lQ59W0A=w170-rw"));
        products.add(new Product("Text Viewer", "https://lh3.googleusercontent.com/nEbxW3nnBR9R0CsptBTbPaoWUb7B_xdBndC_1jj7KRIwC42HjvbVXarb2Bv_NcxUzxM=w170-rw"));
        products.add(new Product("JAJU[자주]", "https://lh3.googleusercontent.com/88DCIGG5H2sXKep_mG20h5GVFXhd4ravYrQuCyoJt0PkYMfWkS0SyY3W1vF6GdZKHwob=w170-rw"));
        products.add(new Product("H.Point", "https://lh3.googleusercontent.com/z_J37CySuBNzlAojRnHH6m29xGkTPHV21umuvNyBBG5LyzmHs5noAvRC7oSPW6zqROKN=w170-rw"));
        products.add(new Product("API Libraries Demo", "https://lh3.googleusercontent.com/D0bkgXTPpQ8lxYoQ0nhOqsqaEiHHDke_g6FebpAlh5E4jRuuqrlnAJTQfLA3s67xirI=w170-rw"));
        products.add(new Product("다음 웹툰", "https://lh3.googleusercontent.com/P4QjRBFIIRQUT3K469ngdLsTydZnQU0v6YXSdtV7S8312elys1a99GTg7_P-v7ugezc=w170-rw"));
        products.add(new Product("Lottie Preview", "https://lh3.googleusercontent.com/WM1WRqHwTccLLpG1v9X3JRiEYv-4PFl9ftPJ7Say62y0UzV3ysZuc_7k8-W8j043w58=w170-rw"));
        products.add(new Product("코믹 스크린", "https://lh5.ggpht.com/tqLu-jNpypRV7DJnHaxNMV-sEMfqLQNAcyQdvOHjLpddGYV8CCLTcYB_UKX-RRp8knk=w170-rw"));
        return products;
    }
}
