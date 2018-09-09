package com.rishi.puzzlemath.util;

import java.util.Random;

public class Util {
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
}
