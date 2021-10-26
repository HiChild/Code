package com.soe.leecode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST2 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double pre = -Double.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre >= root.val) return false;
            pre = (double) root.val;
            root = root.right;
        }
        return true;
    }
}

