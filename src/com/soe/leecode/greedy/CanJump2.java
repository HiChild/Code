package com.soe.leecode.greedy;

public class CanJump2 {
    public boolean canJump(int[] nums) {
        boolean[] enable = new boolean[nums.length];
        enable[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (enable[i] == true) {
                while(nums[i] > 0) {
                    int legal = i + nums[i] > nums.length-1? nums.length-1 :  i + nums[i];
                    enable[legal] = true;
                    nums[i]--;
                }
            }
        }
        return enable[nums.length-1];
    }

    public static void main(String[] args) {
        CanJump2 canJump2 = new CanJump2();
        boolean b = canJump2.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(b);
    }
}
