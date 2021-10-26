package com.soe.leecode.dp;

public class MaxProfitTwo {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        //define status
        int[][] dp = new int[n][2];

        //init
        dp[0][1] = -prices[0];
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
