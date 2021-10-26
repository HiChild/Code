package com.soe.leecode.setmap;

public class TwoSum111 {
    public int[] twoSum(int[] nums, int target) {
        //violent O(n*n)
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
