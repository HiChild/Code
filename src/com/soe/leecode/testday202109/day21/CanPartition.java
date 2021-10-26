package com.soe.leecode.testday202109.day21;

public class CanPartition {
    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        boolean b = canPartition.canPartition(new int[]{1, 5, 10, 6});
        System.out.println(b);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;
        if( sum % 2 != 0) return false;
        int target = sum /2, n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int k = 0; k <= n; ++k) {
            dp[k][0] = true;
        }
        for (int i = 1; i <= n; ++i) {
            int w = nums[i - 1];
            for (int j = 1; j <= target; ++j) {
                if (j >= w) {
                    dp[i][j] =dp[i - 1][j] || dp[i - 1][j - w];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
