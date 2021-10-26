package com.soe.leecode.dp;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] +  Math.max(0,dp[i-1]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
