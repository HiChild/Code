package com.soe.leecode.dp;

import java.util.Arrays;

public class UnquePaths {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        Arrays.fill(res,1);
        for(int i = 1; i<m; i++)
            for (int j = 1; j < n; j++)
                res[j] += res[j-1];

        return res[n-1];
    }

    public static void main(String[] args) {
        UnquePaths unquePaths = new UnquePaths();
        int i = unquePaths.uniquePaths(3,7);
        System.out.println(i);
    }
}
