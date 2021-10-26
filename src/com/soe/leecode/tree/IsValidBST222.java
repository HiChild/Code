package com.soe.leecode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST222 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<>();
        double pre = -Double.MAX_VALUE;
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            int val = root.val;
            if (pre >= val) return false;
            pre = (double) val;
            root = root.right;
        }
        return true;
    }
}

