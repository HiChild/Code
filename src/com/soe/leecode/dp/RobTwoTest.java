package com.soe.leecode.dp;

import java.util.Arrays;

public class RobTwoTest {
    public static int rob(int[] nums) {
        if (nums.length == 1)  return nums[0];
        int A = helper(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int B = helper(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(A, B);
    }

    public static int helper(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max((i >=2 ? nums[i - 2] : 0) + nums[i], nums[i - 1] );
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int rob = rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}
