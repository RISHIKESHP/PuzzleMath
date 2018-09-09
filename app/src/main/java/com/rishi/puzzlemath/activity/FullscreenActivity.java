package com.rishi.puzzlemath.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rishi.puzzlemath.R;
import com.rishi.puzzlemath.adapter.NumberRecyclerAdapter;
import com.rishi.puzzlemath.util.Util;


public class FullscreenActivity extends AppCompatActivity implements NumberRecyclerAdapter.ItemClickListener{
    private RecyclerView mNumberRecyclerView;
    private TextView mNumberTextview;
    private NumberRecyclerAdapter mNumberRecyclerAdapter;
    private Util mUtil;
    private String mNumbers[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mUtil = new Util();
        initViews();
        setNumberValue();
//        setAdapter();
    }

    private void setNumberValue() {
        mUtil.setLevel(4);
        //TODO condition required
        switch (mUtil.getLevel()){
            case 1:
            case 2:
            case 3:
                mUtil.setMin(1);
                mUtil.setMax(15);
                break;
            case 4:
            case 5:
            case 6:
                mUtil.setMin(16);
                mUtil.setMax(30);
                break;
        }
        mNumberTextview.setText(""+mUtil.getRandomNumber(mUtil.getMin(),mUtil.getMax()));
    }

    private void initViews() {
   //     mNumberRecyclerView = findViewById(R.id.rv_numbers);
        mNumberTextview = findViewById(R.id.tv_value);
    }
    private void setAdapter() {
        mNumbers = new String[]{"1","2","3","4","5","6","7","8","9"};
        int numberOfColumns = 3;
        mNumberRecyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        mNumberRecyclerAdapter = new NumberRecyclerAdapter(FullscreenActivity.this,mNumbers);
        mNumberRecyclerAdapter.setClickListener(this);
        mNumberRecyclerView.setAdapter(mNumberRecyclerAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + mNumberRecyclerAdapter.getItem(position) + ", which is at cell position " + position);
    }
}
