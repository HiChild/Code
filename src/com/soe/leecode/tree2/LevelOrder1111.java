package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder1111 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) return res;
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> subRes = new ArrayList<>();
            while (size-- > 0) {
                TreeNode treeNode = deque.poll();
                subRes.add(treeNode.val);
                if (treeNode.left != null) deque.offer(treeNode.left);
                if (treeNode.right != null) deque.offer(treeNode.right);
            }
            res.add(subRes);
        }
        return res;
    }
}
