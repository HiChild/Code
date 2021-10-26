package com.soe.leecode.dp;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]){
                    min = Math.min(dp[i -coins[j]],min);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1);
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
