package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder222 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) dfs(root.left, level + 1);
        if (root.right != null) dfs(root.right, level + 1);
    }
}
