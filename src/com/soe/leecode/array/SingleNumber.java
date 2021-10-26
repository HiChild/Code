package com.soe.leecode.array;

public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        int mask = 0;
        int res = 0;
        for (int num : nums) {
            mask ^= num;
        }
        int theOne = mask & (-mask);
        for(int num: nums) {
            if((num & theOne) == 0) {
                res ^= num;
            }
        }
        return new int[]{res, res ^ mask};
    }
}
