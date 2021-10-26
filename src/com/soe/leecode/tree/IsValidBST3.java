package com.soe.leecode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST3 {
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
