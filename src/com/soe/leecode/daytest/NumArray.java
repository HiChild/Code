package com.soe.leecode.daytest;

public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        //从数组下标从1开始
        sum = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            sum[i] += sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        //因为我们数组是从1开始的
        left++; right++;
        return sum[right] - sum[left - 1];
    }
}
