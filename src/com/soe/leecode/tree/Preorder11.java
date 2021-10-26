package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class Preorder11 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return res;
    }
}
