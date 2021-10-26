package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute1111 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        helper(output, 0);
        return res;
    }

    private void helper(List<Integer> output, int level) {
        if (level == output.size()) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i = level; i < output.size(); i++) {
            Collections.swap(output, i, level);
            helper(output, level + 1);
            Collections.swap(output, i, level);
        }
    }
}
