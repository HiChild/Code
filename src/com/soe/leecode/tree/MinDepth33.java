package com.soe.leecode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class MinDepth33 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int level = 1;
        while (!deque.isEmpty()) {
            int count = deque.size();
            while (count-- > 0) {
                TreeNode nextNode = deque.poll();
                if (nextNode.right == null && nextNode.left == null) return level;
                if (nextNode.left != null) deque.offer(nextNode.left);
                if (nextNode.right != null) deque.offer(nextNode.right);
            }
            level++;
        }
        return level;
    }
}
