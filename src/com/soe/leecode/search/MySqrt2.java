package com.soe.leecode.search;

public class MySqrt2 {
    private int s;
    public int mySqrt(int x) {
        s = x;
        return x==0? 0 : (int) sqrt(x);
    }
    private double sqrt(double x) {
        double res = (x + s/x)/2;
        if (res == x) {
            return res;
        }else {
            return sqrt(res);
        }
    }
}

