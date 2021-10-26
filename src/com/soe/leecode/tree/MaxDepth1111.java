package com.soe.leecode.tree;

public class MaxDepth1111 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right);
    }
}
