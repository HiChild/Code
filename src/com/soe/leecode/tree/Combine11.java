package com.soe.leecode.tree;

import java.util.*;

public class Combine11 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k <= 0) return res;
        Deque<Integer> path = new LinkedList<>();
        backtrack(1, n, k, res, path);
        return res;
    }

    private void backtrack(int began, int n, int k, List<List<Integer>> res, Deque<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = began; i <= n; i++) {
            path.addLast(i);
            backtrack(began + 1, n, k, res, path);
            path.removeLast();
        }
    }
}
