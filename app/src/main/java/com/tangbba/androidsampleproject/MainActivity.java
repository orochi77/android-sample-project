package com.tangbba.androidsampleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.tangbba.androidsampleproject.adapter.BrandRecyclerViewAdapter;
import com.tangbba.androidsampleproject.model.Brand;
import com.tangbba.androidsampleproject.model.BrandResponse;
import com.tangbba.androidsampleproject.model.BrandRepository;
import com.tangbba.androidsampleproject.tasks.DataLoaderAsyncTask;
import com.tangbba.androidsampleproject.utils.KeyboardUtil;
import com.tangbba.androidsampleproject.widget.BrandSearchView;
import com.tangbba.androidsampleproject.widget.ClearEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static int COLUMN_COUNT = 3;

    private DataLoaderAsyncTask mDataLoaderAsyncTask;
    private BrandRepository mBrandRepository;

    private View mRootView;
    private BrandSearchView mSearchView;
    private RecyclerView mRecyclerView;
    private BrandRecyclerViewAdapter mAdapter;
    private GridLayoutManager mGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();

        mBrandRepository = new BrandRepository(this);
        mDataLoaderAsyncTask = new DataLoaderAsyncTask(this, new DataLoaderAsyncTask.OnDataLoadListener() {
            @Override
            public void onLoadComplete(BrandResponse brandResponse) {
                mBrandRepository.setAllBrandList(brandResponse.getBrands());
                setupRecyclerView();
            }
        });
        mDataLoaderAsyncTask.execute();
        setupSearchView();
        setupFocusProcess(mRootView);
    }

    private void initializeUI() {
        mRootView = findViewById(R.id.root_view);
        mSearchView = (BrandSearchView) findViewById(R.id.search_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void setupRecyclerView() {
        mGridLayoutManager = new GridLayoutManager(this, COLUMN_COUNT);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mAdapter = new BrandRecyclerViewAdapter(this, mBrandRepository.getAllBrandList(), mBrandRepository);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setupSearchView() {
        mSearchView.setOnEditorActionListener(mSearchViewEditorActionListener);
        mSearchView.setOnFocusChangeListener(mFocusChangeListener);
        mSearchView.setOnSearchViewTextChangeListener(mSearchViewTextChangeListener);
    }

    private void setupFocusProcess(View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    hideKeyboard();
                    return false;
                }
            });
        }

        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupFocusProcess(innerView);
            }
        }
    }

    private void hideKeyboard() {
        KeyboardUtil.hideSoftKeyboard(mSearchView);
        mRootView.requestFocus();
    }

    private TextView.OnEditorActionListener mSearchViewEditorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_SEARCH:
                    hideKeyboard();
                    break;
            }
            return true;
        }
    };

    private View.OnFocusChangeListener mFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                KeyboardUtil.showImplicitSoftKeyboard(mSearchView);
            } else {
                hideKeyboard();
            }
        }
    };

    private BrandSearchView.OnSearchViewTextChangeListener mSearchViewTextChangeListener = new BrandSearchView.OnSearchViewTextChangeListener() {
        @Override
        public void onChangeText(CharSequence s) {
            String searchWord = s.toString();
            mBrandRepository.setSearchWord(searchWord);
        }
    };

}
