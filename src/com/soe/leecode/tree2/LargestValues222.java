package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.List;

public class LargestValues222 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, 0, root);
        return res;
    }

    private void dfs(List<Integer> res, int level, TreeNode root) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);
        } else {
            res.set(level, Math.max(res.get(level), root.val));
        }
        dfs(res, level + 1, root.left);
        dfs(res, level + 1, root.right);
    }
}
