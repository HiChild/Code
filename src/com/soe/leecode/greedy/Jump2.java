package com.soe.leecode.greedy;

public class Jump2 {
    public int jump(int[] nums) {
        int maxLength = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxLength = Math.max(maxLength, i + nums[i]);
            if (end == i) {
                end = maxLength;
                steps++;
            }
        }
        return steps;
    }
}
