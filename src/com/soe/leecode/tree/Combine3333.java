package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combine3333 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        helper(1, n, k, path, res);
        return res;
    }

    private void helper(int began, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (began > n - k + 1) return;
        helper(began + 1, n, k, path, res);
        path.addLast(began);
        helper(began + 1, n, k - 1, path, res);
        path.removeLast();
    }
}
