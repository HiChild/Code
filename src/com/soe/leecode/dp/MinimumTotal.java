package com.soe.leecode.dp;

import java.util.Arrays;
import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        //从三角形底边到顶点动态规划，
        int m = triangle.size();
        int[][] res = new int[m + 1 ][m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[i][j] = triangle.get(i).get(j) + Math.min(res[i+1][j],res[i+1][j+1]);
            }
        }

        return res[0][0];
    }
}
