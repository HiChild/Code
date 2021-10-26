package com.soe.leecode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Combine33 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k <= 0) return res;
        Deque<Integer> path = new LinkedList<>();
        //不选或者选
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

        //选
        path.addLast(began);
        dsf(began + 1, n, k - 1, res, path);
        //回溯
        path.removeLast();
    }
}
