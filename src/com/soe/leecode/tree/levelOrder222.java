package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class levelOrder222 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) order(root, 0);
        return res;
    }

    private void order(Node root, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (Node child : root.children) {
            order(child, level + 1);
        }
    }

}
