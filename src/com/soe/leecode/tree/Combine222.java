package com.soe.leecode.tree;

import java.util.*;

public class Combine222 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k <= 0) {
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        dsf(1, n, k, res, path);
        return res;
    }

    private void dsf(int began, int n, int k, List<List<Integer>> res, Deque<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = began; i <= (n - (k - path.size()) + 1); i++) {
            path.addLast(i);
            dsf(i + 1, n, k, res, path);
            path.removeLast();
        }
    }
}
