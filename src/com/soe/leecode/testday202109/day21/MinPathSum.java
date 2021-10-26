package com.soe.leecode.testday202109.day21;


import java.util.Arrays;

public class MinPathSum {

    static int[][] test = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
    };

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        MinPathSum minPathSum = new MinPathSum();
        int i = minPathSum.minPathSum(test);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) res[i][0] = Integer.MAX_VALUE;
        for (int i = 0; i <= n; ++i) res[0][i] = Integer.MAX_VALUE;
        res[1][1] = grid[0][0];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i == 1 && j == 1) continue;
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return res[m][n];
    }
}
