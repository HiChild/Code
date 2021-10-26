package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermuteUnique11 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return res;
        ArrayList<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        helper(output, 0);
        return res;
    }

    private void helper(ArrayList<Integer> output, int level) {
        if (output.size() == level) {
            res.add(new ArrayList<>(output));
            return;
        }

        for (int i = level; i < output.size(); i++) {
            if (isOK(output, level, i)) {
                Collections.swap(output, level, i);
                helper(output, level + 1);
                Collections.swap(output, level, i);
            }
        }
    }

    private boolean isOK(ArrayList<Integer> output, int start, int end) {
        for (int i = start; i < end; i++) {
            if (output.get(i) == output.get(end)) {
                return false;
            }
        }
        return true;
    }
}

