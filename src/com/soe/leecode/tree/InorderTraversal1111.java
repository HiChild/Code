package com.soe.leecode.tree;


import java.util.ArrayList;
import java.util.List;

public class InorderTraversal1111 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        generator(root, res);
        return res;
    }

    private void generator(TreeNode node, List<Integer> res) {
        if (node != null) {
            generator(node.left, res);
            res.add(node.val);
            generator(node.right, res);
        }
    }
}
