package com.soe.leecode.offer;

import java.util.Arrays;

public class IsStrate {
    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int king = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                king++;
                continue;
            }
            if (nums[i] == nums[i + 1]) return false;
        }
        return (nums[nums.length - 1] - nums[king]) < 5;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{9,10,4,0,9}));
    }
}
