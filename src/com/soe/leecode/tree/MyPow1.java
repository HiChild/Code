package com.soe.leecode.tree;

public class MyPow1 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long n) {
        if (n == 0) return 1.0;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
//    public double quickMul(double x, long N) {
//        if (N == 0) {
//            return 1.0;
//        }
//        double y = quickMul(x, N / 2);
//        return N % 2 == 0 ? y * y : y * y * x;
//    }
//
//    public double myPow(double x, int n) {
//        long N = n;
//        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
//    }