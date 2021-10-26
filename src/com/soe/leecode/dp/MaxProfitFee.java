package com.soe.leecode.dp;

public class MaxProfitFee {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) return 0;

        int[][] dp = new int[len][2]; //表示第i天 操作后是什么状态，并且操作后的金钱是多少。
        //定义状态方程
        dp[0][0] = 0;
        dp[0][1] = -fee-prices[0];

        //从第二天开始
        for(int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i] - fee);
        }
        return dp[len - 1][0];
    }
}
