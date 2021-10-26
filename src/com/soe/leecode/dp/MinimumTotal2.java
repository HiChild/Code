package com.soe.leecode.dp;

import java.util.List;

public class MinimumTotal2 {
    //空间优化
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j] , dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
