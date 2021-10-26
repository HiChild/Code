package com.soe.leecode.math;

import java.util.Random;

public class Shuffle {
    int[] origin;
    int[] shuffled;
    Random rand = new Random();

    public Shuffle(int[] nums) {
        shuffled = nums;
        origin = nums.clone();
    }

    public int[] reset() {
        if (origin.length == 0) return new int[]{};
        int n = shuffled.length;
//        逆向洗牌
        for (int i = n - 1; i >= 0; --i) {
            swap(shuffled, i, rand.nextInt(i + 1));
        }
//        正向洗牌
//        for (int i = 0; i < n; i ++) {
//            int pos = rand.nextInt(n - i);
//            swap(shuffled, i, i + pos);
//        }
        return shuffled;
    }

    public int[] shuffle() {
        return origin;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
