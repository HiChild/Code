package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permute222 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return res;
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, path, used);
        return res;
    }

    private void helper(int[] nums, Deque<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                helper(nums, path, used);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
