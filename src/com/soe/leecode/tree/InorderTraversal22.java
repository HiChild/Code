package com.soe.leecode.tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal22 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
