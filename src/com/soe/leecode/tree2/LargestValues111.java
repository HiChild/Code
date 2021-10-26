package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestValues111 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int count = deque.size();
            double max = -Double.MAX_VALUE;
            while (count-- > 0) {
                TreeNode nextNode = deque.poll();
                if (nextNode.val > max) max = nextNode.val;
                if (nextNode.left != null) deque.offer(nextNode.left);
                if (nextNode.right != null) deque.offer(nextNode.right);
            }
            res.add((int) max);
        }
        return res;
    }
}
