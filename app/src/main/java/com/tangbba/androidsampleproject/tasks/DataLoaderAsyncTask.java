package com.tangbba.androidsampleproject.tasks;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.GsonBuilder;
import com.tangbba.androidsampleproject.model.BrandResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by orochi77 on 2018-01-19.
 */

public class DataLoaderAsyncTask extends AsyncTask<Void, Void, BrandResponse> {

    private static final String TAG = "DataLoaderAsyncTask";

    private Context mContext;
    private OnDataLoadListener mOnDataLoadListener;

    public DataLoaderAsyncTask(Context context, OnDataLoadListener onDataLoadListener) {
        mContext = context;
        mOnDataLoadListener = onDataLoadListener;
    }

    @Override
    protected BrandResponse doInBackground(Void... voids) {
        AssetManager assetManager = mContext.getAssets();

        BufferedReader bufferedReader = null;
        BrandResponse brandResponse = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open("brands.json")));
            StringBuilder stringBuilder = new StringBuilder();
            String tempString;

            while ((tempString = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempString);
            }

            brandResponse = (new GsonBuilder().create()).fromJson(stringBuilder.toString(), BrandResponse.class);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        }

        return brandResponse;
    }

    @Override
    protected void onPostExecute(BrandResponse brandResponse) {
        super.onPostExecute(brandResponse);
        if (mOnDataLoadListener != null) {
            mOnDataLoadListener.onLoadComplete(brandResponse);
        }
    }

    public OnDataLoadListener getOnDataLoadListener() {
        return mOnDataLoadListener;
    }

    public void setOnDataLoadListener(OnDataLoadListener onDataLoadListener) {
        mOnDataLoadListener = onDataLoadListener;
    }

    public interface OnDataLoadListener {
        void onLoadComplete(BrandResponse brandResponse);
    }
}
