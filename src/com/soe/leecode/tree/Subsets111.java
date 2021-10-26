package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Subsets111 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Deque<Integer> path = new LinkedList<>();
        helper(res, path, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, Deque<Integer> path, int[] nums, int level) {
        if (level == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        helper(res, path, nums, level + 1);
        path.addLast(nums[level]);
        helper(res, path, nums, level + 1);
        path.removeLast();
    }
}
