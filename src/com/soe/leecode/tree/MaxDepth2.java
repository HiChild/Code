package com.soe.leecode.tree;

public class MaxDepth2 {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int level) {
        if (root == null) return 0;
        int left = helper(root.left, level + 1);
        int right = helper(root.right, level + 1);
        return Math.max(left, right) + 1;
    }
}
