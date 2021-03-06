package com.soe.leecode.dp;

public class maxProfitThree {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        //定义状态
        int[][][] dp = new int[len][3][2];
        //初始化状态
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], - prices[i]);
        }
        return dp[len - 1][2][0];
    }
}
