package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class levelOrder1 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Node> deque = new LinkedList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return res;
        }
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int count = deque.size();
            while (count-- > 0) {
                Node nextNode = deque.removeLast();
                ans.add(nextNode.val);
                for (Node child : nextNode.children) {
                    if (child != null) {
                        deque.addFirst(child);
                    }
                }
            }
            res.add(ans);
        }
        return res;
    }
}
