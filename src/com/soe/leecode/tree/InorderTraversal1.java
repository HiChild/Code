package com.soe.leecode.tree;


import java.util.ArrayList;
import java.util.List;

public class InorderTraversal1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bianli(root, res);
        return res;
    }

    public void bianli(TreeNode treeNode, List<Integer> res) {
        if (treeNode != null) {
            bianli(treeNode.left, res);
            res.add(treeNode.val);
            bianli(treeNode.right, res);
        }
    }
}
