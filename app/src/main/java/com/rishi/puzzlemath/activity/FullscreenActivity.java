package com.rishi.puzzlemath.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rishi.puzzlemath.R;
import com.rishi.puzzlemath.util.Util;


public class FullscreenActivity extends AppCompatActivity {
    private TextView mNumberTextview;
    private Util mUtil;


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
                mUtil.setMin(50);
                mUtil.setMax(100);
                break;
        }
        int result = mUtil.getRandomNumber(mUtil.getMin(),mUtil.getMax());
        mNumberTextview.setText(""+result);
        mUtil.getPossibleList(result);
    }

    private void initViews() {
        mNumberTextview = findViewById(R.id.tv_value);
    }

}
