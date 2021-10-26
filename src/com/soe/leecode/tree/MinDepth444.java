package com.soe.leecode.tree;

public class MinDepth444 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int rigth = minDepth(root.right);
        return (left == 0 || rigth == 0) ? rigth + left + 1 : Math.min(rigth, left) + 1;
    }
}