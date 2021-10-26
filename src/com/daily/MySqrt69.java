package com.daily;

/**
 * leecode 69
 */
public class MySqrt69 {
    /**
     * 二分法
     */
    public int mySqrt(int x) {
        int l = 0, r = x, mid;
        while (l <= r) {
            mid = (l + r) >> 1;
            if ((long)mid * mid <= x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }


    /**
     * 牛顿迭代法 迭代写法
     */
    public int mySqrt1(int x) {
        if (x == 0) return 0;
        return sqrt1(x);
    }

    int sqrt1(int x){
        long a = x;
        while (a * a > x) {
            a = (a + x/a)/2;
        }
        return (int)a;
    }

    /**
     * 牛顿迭代法 递归写法
     */
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        return (int)sqrt2(x, x);
    }

    double sqrt2(double i, int x){
        double n = (i + x/i) / 2;
        if (n == i) return i;
        return sqrt2(n , x);
    }
}
