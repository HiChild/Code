package com.soe.leecode.greedy;

public class CanJump {
    public boolean canJump(int[] nums) {
        int enableArr = nums.length - 1;
        for (int i = enableArr; i>=0; i--) {
            if  (nums[i] + i >= enableArr) {
                enableArr = i;
            }
        }
        return enableArr == 0;
    }
}

