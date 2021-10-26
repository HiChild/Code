package com.soe.leecode.dp;

public class RobOne {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        //define status
        int[] dp = nums;
        //switch status
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max((i >= 2 ? dp[i-2] : 0) + nums[i], dp[i - 1]);
        }
        return dp[n -1];
    }

//    public int rob(int[] nums) {
//        int n = nums.length;
//        if (n < 1) return 0;
//        if (n < 2) return nums[0];
//        //define status
//        int[] dp = nums;
//        dp[1] = Math.max(nums[0],nums[1]);
//        //switch status
//        for (int i = 2; i < n; i++) {
//            dp[i] = Math.max( dp[i-2] + nums[i], dp[i - 1]);
//        }
//        return dp[n -1];
//    }


//    class Solution {
//        public int rob(int[] nums) {
//            int len = nums.length;
//            if(len == 0)
//                return 0;
//            int[] dp = new int[len + 1];
//            dp[0] = 0;
//            dp[1] = nums[0];
//            for(int i = 2; i <= len; i++) {
//                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
//            }
//            return dp[len];
//        }
//    }


}
