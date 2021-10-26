package com.soe.leecode.greedy;

public class Jump {
    public int jump(int[] nums) {
        int enablePos = nums.length -1;
        int steps = 0;
        while (enablePos > 0) {
            for (int i = 0; i < enablePos; i++ ) {
                if (enablePos <= i + nums[i]) {
                    enablePos = i;
                    steps++;
                }
            }
        }
        return steps;
    }
}
