package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> subRes = new ArrayList<>();
            while (count-- > 0) {
                TreeNode nextNode = deque.poll();
                subRes.add(nextNode.val);
                if (nextNode.left != null) deque.offer(nextNode.left);
                if (nextNode.right != null) deque.offer(nextNode.right);
            }
            res.add(subRes);
        }
        return res;
    }
}
