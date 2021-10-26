package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class Postorder11 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }

        for (Node child : root.children) {
            postorder(child);
        }
        res.add(root.val);
        return res;
    }
}
