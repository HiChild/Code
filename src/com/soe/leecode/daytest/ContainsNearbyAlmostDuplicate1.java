package com.soe.leecode.daytest;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate1 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 1) return false;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Long u = nums[i] * 1L;
            Long l = ts.floor(u);
            Long r = ts.ceiling(u);
            if (l != null && l >= u - t) return true;
            if (r != null && r <= u + t) return true;
            ts.add(u);
            if (i >= k) ts.remove(nums[i - k] * 1L);
        }
        return false;
    }
}
