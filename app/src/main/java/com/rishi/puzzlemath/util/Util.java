package com.rishi.puzzlemath.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Util {
    private String TAG = Util.class.getSimpleName();
    private int min;
    private int max;
    private int level;
    private ArrayList<String> mMultipleList;
    private ArrayList<String> mAdditionList;
    private ArrayList<String> mDevisionList;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getRandomNumber(int min, int max){
        return new Random().nextInt((max - min) + 1) + min;
    }
    public String getAdditonProb()
    {
        String mAdditionProb = "";
        if (mAdditionList == null || mAdditionList.size() == 0)
            return mAdditionProb;
        mAdditionProb = mAdditionList.get(getRandomValueForList(mAdditionList.size()-1));
        return mAdditionProb;
    }
    public String getMulProb()
    {
        String mMultiplicationProb = "";
        if (mMultipleList == null || mMultipleList.size() == 0)
            return mMultiplicationProb;
        mMultiplicationProb = mMultipleList.get(getRandomValueForList(mMultipleList.size()-1));
        return mMultiplicationProb;
    }
    public String getDevProb()
    {
        String mDevisionProb = "";
        if (mDevisionList == null || mDevisionList.size() == 0)
            return mDevisionProb;
        mDevisionProb = mDevisionList.get(getRandomValueForList(mDevisionList.size()-1));
        return mDevisionProb;
    }
    private int getRandomValueForList(int listSize){
        return new Random().nextInt((listSize - 1) + 1) + 1;
    }
    public void getPossibleList(int number)
    {
        int mNumber = number;
        mMultipleList = new ArrayList<>();
        mAdditionList = new ArrayList<>();
        mDevisionList = new ArrayList<>();

       for (int i = 1; i <= mNumber ;i++)
        {
           for (int j = mNumber; j > 0; j--){
               if (i * j == mNumber){
                   mMultipleList.add(i+"*"+j);
                  // int biggerNum = i > j ? i : j;
                   Log.d(TAG,"possible lists mul are :"+i+"*"+j);
               }
               if (i + j == mNumber){
                   mAdditionList.add(i+"+"+j);
                   Log.d(TAG,"possible lists add are :"+i+"+"+j);
               }
           }
           int mul = 0;
           if (i > 1) {
               mul = i * mNumber;
               mDevisionList.add(mul+"/"+i);
               Log.d(TAG, "devision list :" + mul + "/" + i + "=" + mNumber);
           }

        }
        Log.d(TAG,"mMultipleList IS :"+mMultipleList.toString());
        Log.d(TAG,"mAdditionList IS :"+mAdditionList.toString());
        Log.d(TAG,"mDevisionList IS :"+mDevisionList.toString());

    }
    public void clearAllData(){
        mMultipleList = null;
        mAdditionList = null;
        mDevisionList = null;
    }
}
