package com.soe.leecode.tree;

import java.util.*;

public class Combine333 {
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
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (began > n - k + 1) return;

        //不选
        dsf(began + 1, n, k, res, path);
        path.addLast(began);
        dsf(began + 1, n, k - 1, res, path);
        path.removeLast();
    }
}
