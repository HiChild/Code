package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.List;

public class LargestValues22 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }


    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
