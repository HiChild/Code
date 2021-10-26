package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class levelOrder111 {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Node> deque = new LinkedList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return res;
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> ans = new ArrayList<>();
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
