package com.soe.leecode.search;

public class MySqrt1_5 {
    public int mySqrt(int x) {
        int l = 0;
        int right = x;
        while(l <= right) {
            int mid =l + (right - l)/2;
            if ((long) mid * mid <= x) {
                l = mid + 1;
            }else {
                right = mid-1;
            }
        }
        //right  + 1 = l
        return right;
    }

    public static void main(String[] args) {
        MySqrt1_5 mySqrt = new MySqrt1_5();
        int res = mySqrt.mySqrt(2147395600);
        System.out.println(res);
    }
}

