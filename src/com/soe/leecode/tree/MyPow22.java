package com.soe.leecode.tree;

public class MyPow22 {
    public double myPow(double x, int n) {
        if (x == 0) return 0.0;
        long m = n;
        if (m < 0) {
            x = 1.0 / x;
            m = -m;
        }
        double res = 1.0;
        while (m > 0) {
            if ((m & 1) == 1) res *= x;
            x *= x;
            m >>= 1;
        }
        return res;
    }
}
