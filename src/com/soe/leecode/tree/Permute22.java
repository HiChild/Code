package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Permute22 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, nums, used, path);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, boolean[] used, Deque<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                tmp.addLast(nums[i]);
                used[i] = true;
                backtrack(res, nums, used, tmp);
                used[i] = false;
                tmp.removeLast();
            }
        }
    }
}
