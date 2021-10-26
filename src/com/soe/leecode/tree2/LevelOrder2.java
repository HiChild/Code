package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        order(root, 0);
        return res;
    }

    private void order(TreeNode root, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if (root.left != null) order(root.left, level + 1);
        if (root.right != null) order(root.right, level + 1);
    }
}
