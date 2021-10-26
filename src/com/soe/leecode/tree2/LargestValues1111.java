package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestValues1111 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int count = deque.size();
            double max = -Double.MAX_VALUE;
            while (count-- > 0) {
                TreeNode node = deque.poll();
                if (max < node.val) max = node.val;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            res.add((int) max);
        }
        return res;
    }
}
