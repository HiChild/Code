package com.soe.leecode.daytest;

/**
 * 对一个升序的数组，前k个重复的数字可以保留，返回数组的长度即可
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    private int process(int[] nums, int k) {
        int idx = 0;
        //前k个元素直接放入
        //然后比较从当前位置往前k个元素，如果当前元素和前面的元素不一样则放入
        for (int x : nums) {
            if (idx < k || nums[idx - k] != x) nums[idx++] = x;
        }
        return idx;
    }


}
