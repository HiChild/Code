package com.soe.leecode.dp;

import java.util.Arrays;

public class RoberTwo {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        if (len == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums,0,len-1)),
                myRob(Arrays.copyOfRange(nums,1,len)));
    }

    public int myRob (int[] nums) {
        int pre = 0, cur = 0;
        for (int num : nums) {
            int temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }

//    public int rob(int[] nums) {
//        int len = nums.length;
//        if (len < 1) return 0;
//        if (len == 1) return nums[0];
//        return Math.max(myRob(Arrays.copyOfRange(nums,0,len-1)),
//                myRob(Arrays.copyOfRange(nums,1,len)));
//    }
//
//    public int myRob (int[] nums) {
//        int len = nums.length;
//        int[] dp = new int[len + 1];
//        dp[0] = 0;
//        dp[1] = nums[0];
//        for (int i = 2; i <= len; i++) {
//            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
//        }
//        return dp[len];
//    }





}
