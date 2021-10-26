package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens1 {

    public List<List<String>> solveNQueens(int n) {
        int[] x = new int[n];
        List<List<String>> res = new ArrayList<>();
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
                backtrack(res, level + 1, x.clone());
            }
        }
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
        }
        for (int i = 0; i < n; i++) {
            ret.add(new String(chess[i]));
        }
        return ret;
    }

    private boolean isOk(int[] x, int level) {
        for (int i = 0; i < level; i++) {
            if (Math.abs(level - i) == Math.abs(x[level] - x[i]) || x[i] == x[level]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens1 solveNQueens1 = new SolveNQueens1();
        List<List<String>> lists = solveNQueens1.solveNQueens(8);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    private void printNum(int[] x) {
        for (int i : x) {
            System.out.print(i);
        }
        System.out.println();
    }
}
