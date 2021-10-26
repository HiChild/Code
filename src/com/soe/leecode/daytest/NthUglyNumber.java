package com.soe.leecode.daytest;

import java.util.ArrayList;
import java.util.List;

public class NthUglyNumber {

    public static void main(String[] args) {
        nthUglyNumber(9);
    }

    public static int nthUglyNumber(int n) {
        List<Integer> list =new ArrayList<>();
        int num = 1;
        while(list.size() < n ) {
            int tem = num;
            while (num % 2 == 0) num /= 2;
            while (num % 3 == 0) num /= 3;
            while (num % 5 == 0) num /= 5;
            if (num == 1) {
                list.add(tem);
            }
            num = tem + 1;
        }
        return list.get(n - 1 );
    }


//    public int nthUglyNumber(int n) {
//        int[] res = new int[n + 1];
//        res[1] = 1;
//        for (int i2 = 1, i3 = 1, i5 = 1, idx = 2; idx <= n; idx++ ) {
//            int a = res[i2] * 2, b = res[i3] * 3, c = res[i5] * 5;
//            int min = Math.min(a, Math.min(b,c));
//            res[idx] = min;
//            if (min == a) i2++;
//            if (min == b) i3++;
//            if (min == c) i5++;
//        }
//        return res[n];
//    }s
}
