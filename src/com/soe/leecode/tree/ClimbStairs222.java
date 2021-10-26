package com.soe.leecode.tree;

public class ClimbStairs222 {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}
