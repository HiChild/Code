package com.soe.leecode.tree;

import java.util.*;

public class Permute2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, nums, used, new LinkedList<Integer>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, boolean[] used, Deque<Integer> tmp) {
        if (tmp.size() == nums.length) res.add(new ArrayList<>(tmp));
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                tmp.addLast(nums[i]);
                used[i] = true;
                backtrack(res, nums, used, tmp);
                tmp.removeLast();
                used[i] = false;
            }
        }
    }
}
