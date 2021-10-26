package com.datastructure.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length , inorder, 0, inorder.length, map);
    }

    /**
     p_s :preorder_start
     p_e :preorder_end
     i_s :inorder_start
     i_e :inorder_end
     */
    public TreeNode helper(int[] preorder, int p_s, int p_e, int[] inorder, int i_s, int i_e, Map<Integer,Integer> map) {
        if (p_s == p_e) return null; //前序子树长度为0则递归终止
        int root_val = preorder[p_s];
        TreeNode root = new TreeNode(root_val);
        int i_index_root = map.get(root_val);
        int leftNum = i_index_root - i_s;

        root.left = helper(preorder, p_s + 1, p_s + leftNum + 1, inorder, i_s, i_index_root, map);
        root.right = helper(preorder, p_s + leftNum + 1, p_e, inorder,i_index_root + 1, i_e, map);
        return root;
    }
}
