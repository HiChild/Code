package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermuteUnique1 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        helper(output, 0);
        return res;
    }

    private void helper(List<Integer> output, int level) {
        if (level == output.size()) res.add(new ArrayList<Integer>(output));
        for (int i = level; i < output.size(); i++) {
            if (isOk(output, level, i)) {
                Collections.swap(output, i, level);
                helper(output, level + 1);
                Collections.swap(output, i, level);
            }
        }
    }

    private boolean isOk(List<Integer> num, int start, int end) {
        for (int i = start; i < end; i++) {
            if (num.get(i) == num.get(end)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PermuteUnique1 p = new PermuteUnique1();
        List<List<Integer>> ress = p.permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> res : ress) {
            System.out.println(res);
        }
    }
}

