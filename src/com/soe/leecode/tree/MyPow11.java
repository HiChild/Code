package com.soe.leecode.tree;

public class MyPow11 {
    public double myPow(double x, int n) {
        long m = n;
        return m >= 0 ? quickMul(x, m) : 1.0 / quickMul(x, -m);
    }

    private double quickMul(double x, long m) {
        if (m == 0) return 1.0;
        double y = quickMul(x, m / 2);
        return m % 2 == 0 ? y * y : x * y * y;
    }
}
