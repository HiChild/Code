package com.soe.leecode.tree;

public class MinDepth4444 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? right + left + 1 : Math.min(left, right) + 1;
    }
}