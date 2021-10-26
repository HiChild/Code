package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class levelOrder22 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) order(root, 0);
        return res;
    }

    private void order(Node node, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        for (Node child : node.children) {
            order(child, level + 1);
        }
    }
}
