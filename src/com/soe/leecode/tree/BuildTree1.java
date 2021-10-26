package com.soe.leecode.tree;

public class BuildTree1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_end == p_start) return null;
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (inorder[i] == root_val) {
                i_root_index = i;
                break;
            }
        }

        int leftNum = i_root_index - i_start;
        root.left = helper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        root.right = helper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }
}
