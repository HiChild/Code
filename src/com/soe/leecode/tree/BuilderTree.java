package com.soe.leecode.tree;

import com.soe.leecode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuilderTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length,map);
    }
    public TreeNode helper(int[] preorder,int p_start,int p_end, int[] inorder,int i_start,int i_end,Map<Integer,Integer> map)     {
        if (p_end == p_start) return null;

        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_index_root = map.get(root_val);
        int leftNum = i_index_root - i_start;

        root.left = helper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start,i_index_root, map);
        root.right = helper(preorder, p_start + leftNum + 1,p_end, inorder, i_index_root + 1,i_end,map);
        return root;
    }
}
