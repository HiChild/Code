package com.soe.leecode.setmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum222 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (ans.containsKey(target - nums[i])) {
                return new int[]{ans.get(target - nums[i]), i};
            }
            ans.put(nums[i], i);
        }
        return new int[0];
    }
}
