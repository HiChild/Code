package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal1111 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        generator(root, res);
        return res;
    }

    private void generator(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            generator(node.left, res);
            generator(node.right, res);
        }
    }
}
