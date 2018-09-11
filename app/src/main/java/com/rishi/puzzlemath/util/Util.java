package com.rishi.puzzlemath.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Util {
    private String TAG = Util.class.getSimpleName();
    private int min;
    private int max;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level;

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
    public void getPossibleList(int number)
    {
        int mNumber = number;
        ArrayList<String> mMultipleList = new ArrayList<>();
        ArrayList<String> mAdditionList = new ArrayList<>();
        ArrayList<String> mDevisionList = new ArrayList<>();

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
}
