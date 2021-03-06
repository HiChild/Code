package com.soe.leecode.tree;

public class IsValidBST111 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        int val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        if (!helper(root.left, lower, val)) return false;
        if (!helper(root.right, val, upper)) return false;
        return true;
    }

}
