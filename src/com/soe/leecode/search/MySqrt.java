package com.soe.leecode.search;

public class MySqrt {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (  (long)mid*mid  <= x) {
                ans = mid;
                l = mid + 1 ;
            } else {
                r = mid ;
            }
        }
        return (long)l * l <= x ? l : l - 1 ;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        int res = mySqrt.mySqrt(2147395600);
        System.out.println(res);
    }
}

