package com.soe.leecode.tree;

public class MyPow111 {
    public double myPow(double x, int n) {
        long m = n;
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    private double quickMul(double x, int n) {
        if (n == 0) return 1.0;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : x * y * y;
    }
}
