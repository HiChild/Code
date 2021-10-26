package com.soe.leecode.dp;

public class maxProfitFour {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        //define status
        if (k >= n/2) return maxProfit(prices);
        int[][][] dp = new int[n][k+1][2];

        //init
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        //switch status
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[n-1][k][0];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
