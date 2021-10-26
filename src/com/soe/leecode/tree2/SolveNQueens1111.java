package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens1111 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int[] x = new int[n];
        backtrack(res, 0, x);
        return res;
    }

    private void backtrack(List<List<String>> res, int level, int[] x) {
        if (level == x.length) {
            res.add(construct(x));
            return;
        }
        for (int i = 0; i < x.length; i++) {
            x[level] = i;
            if (isOk(x, level)) {
                backtrack(res, level + 1, x);
            }
        }
    }

    private boolean isOk(int[] x, int level) {
        for (int i = 0; i < level; i++) {
            if (Math.abs(i - level) == Math.abs(x[i] - x[level]) || x[i] == x[level]) return false;
        }
        return true;
    }

    private List<String> construct(int[] x) {
        List<String> ret = new ArrayList<>();
        int n = x.length;
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
            chess[i][x[i]] = 'Q';
            ret.add(new String(chess[i]));
        }
        return ret;
    }
}
