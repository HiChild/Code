package com.soe.leecode.tree;

public class BuildTree11111 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length) ;
    }

    private TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int in_start, int in_end) {
        if (p_start == p_end) return null;
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        int in_root_index = 0;
        for (int i = in_start; i < in_end; i++) {
            if (inorder[i] == root_val) {
                in_root_index = i;
                break;
            }
        }
        int leftNum = in_root_index - in_start;

        root.left = helper(preorder,p_start + 1,p_start + leftNum + 1,inorder, in_start, in_start + in_root_index);
        root.right = helper(preorder,p_start + leftNum + 1,p_end,inorder, in_root_index + 1, in_end);
        return root;
    }


}
