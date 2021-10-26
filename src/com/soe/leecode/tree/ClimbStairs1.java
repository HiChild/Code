package com.soe.leecode.tree;

public class ClimbStairs1 {
    public int climbStairs(int n) {
        return generator(n);
    }

    private int generator(int n) {
        //terminator
        if (n == 1) return 1;
        if (n == 2) return 2;

        //logic possess

        //drill down
        return generator(n - 1) + generator(n - 2);
        //reserve set
    }
}
