package com.soe.leecode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combine2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;  //不满足情况
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int began, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }


        for (int i = began; i <= (n - (k - path.size()) + 1); i++) {  //剪枝
            path.addLast(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
