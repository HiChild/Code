package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            root = root.right;
        }
        return res;
    }
}
