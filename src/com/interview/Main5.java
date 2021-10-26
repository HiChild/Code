package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<int[]> action1 = new ArrayList<>();
        for (int i =0; i < n; ++i) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int v = sc.nextInt();
            action1.add(new int[]{l, r, v});
        }
        List<int[]> action2 = new ArrayList<>();
        for (int i =0; i < m; ++i) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int v = sc.nextInt();
            action2.add(new int[]{l, r, v});
        }

        help (action1, action2, n, m, k);
    }

    private static int help(List<int[]> action1, List<int[]> action2, int n, int m, int k) {
        int s = Math.min(m, n);
        for (int i = 0; i < s; ++i) {
            int[] act1 = action1.get(i);
            int[] act2= action2.get(i);
            boolean isActionRight = act1[2] == act2[0];

        }
        return 0;
    }
}
