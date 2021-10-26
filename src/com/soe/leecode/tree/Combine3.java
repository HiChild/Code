package com.soe.leecode.tree;

import java.util.*;

public class Combine3 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || k <= 0) return res;
        Deque<Integer> path = new LinkedList<>();
        //不选或者选
        dsf(1, n, k, path, res);
        return res;
    }

    private void dsf(int began, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        //剪枝后的条件
        if (began > n - k + 1) return; //剪枝前的条件为 began == n + 1

        //不选
        dsf(began + 1, n, k, path, res);
        //选
        path.addLast(began);
        dsf(began + 1, n, k - 1, path, res);
        //回溯
        path.removeLast();
    }
}
