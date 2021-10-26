package com.soe.leecode.tree;

public class MaxDepth1 {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int level) {
        if (root == null) return level;
        int left = helper(root.left, level + 1);
        int right = helper(root.right, level + 1);
        return Math.max(left, right);
    }
}
