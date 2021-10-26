package com.datastructure.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelNodes {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> dict = new HashSet<>();
        for (int x: to_delete) {
            dict.add(x);
        }
        root = helper (root , dict, forest);
        if (root != null) {
            forest.add(root);
        }
        return forest;
    }

    public TreeNode helper(TreeNode root, Set<Integer> dict,List<TreeNode> forest) {
        if (root == null) {
            return root;
        }
        root.left = helper(root.left, dict, forest);
        root.right = helper(root.right, dict, forest);
        if (dict.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            if (root.right != null) {
                forest.add(root.right);
            }
            root = null;
        }
        return root;
    }


}
