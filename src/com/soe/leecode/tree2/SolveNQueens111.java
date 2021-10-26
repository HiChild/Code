package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens111 {

    public List<List<String>> solveNQueens(int n) {
        int[] x = new int[n];
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;
        backtrack(res, x, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, int[] x, int level) {
        if (level == x.length) {
            res.add(construct(x));
        } else {
            for (int i = 0; i < x.length; i++) {
                x[level] = i;
                if (isOk(x, level)) {
                    backtrack(res, x, level + 1);
                }
            }
        }
    }

    private boolean isOk(int[] x, int level) {
        for (int i = 0; i < level; i++) {
            if (Math.abs(x[i] - x[level]) == Math.abs(level - i) || x[i] == x[level]) return false;
        }
        return true;
    }

    private List<String> construct(int[] x) {
        int n = x.length;
        List<String> ret = new ArrayList<>();
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


    public static void main(String[] args) {
        SolveNQueens111 solveNQueens1 = new SolveNQueens111();
        List<List<String>> lists = solveNQueens1.solveNQueens(4);
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
