package com.soe.leecode.tree;

public class IsValidBST3333 {
    private Double pre = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    private boolean helper(TreeNode node) {
        if (node == null) return true;
        if (!helper(node.left)) return false;
        if (pre >= node.val) return false;
        pre = (double) node.val;
        return helper(node.right);
    }
}
