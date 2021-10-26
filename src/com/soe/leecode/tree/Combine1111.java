package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combine1111 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k < 0) return res;
        Deque<Integer> path = new LinkedList<>();
        helper(1, n, k, res, path);
        return res;
    }

    private void helper(int began, int n, int k, List<List<Integer>> res, Deque<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = began; i <= n; i++) {
            path.addLast(i);
            helper(i + 1, n, k, res, path);
            path.removeLast();
        }
    }
}
