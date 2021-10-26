package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new LinkedList<>(), 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, LinkedList<Integer> path, Integer level) {
        if (level == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        //不选
        helper(res, nums, path, level + 1);
        //选
        path.addLast(nums[level]);
        helper(res, nums, path, level + 1);
        //回溯
        path.removeLast();
    }
}
