package com.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main4 {
    //第一行一个正整数n(1≤n≤5x104) 表示点的个数
    //
    //第二行n个空格隔开的互不相同的正整数 a1,a2,....,an(1≤ai≤n) 。
    //
    //第三行n-1个空格隔开的正整数 f2，f3,..fn(1≤fi≤n), fi 表示 i 与fi相连。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] points = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            points[i] = sc.nextInt();
        }
        int[] roads = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            roads[i] = sc.nextInt();
        }
        int[] help = help(points, roads, n);
        int i = 0;
        for ( ; i < help.length - 1; ++i) {
            System.out.print(help[i] + " ");
        }
        System.out.print(help[i]);
    }

    private static int[] help(int[] points, int[] roads, int n) {
        boolean[][] go = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 2; j <=n ; ++j) {
                if (i == j) {
                    go[i][j] = true;
                }
            }
        }
        for (int i = 2; i <= n; ++i) {
            go[roads[i]][i] = true;
            go[i][roads[i]] = true;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[n];
        for (int i = 1; i <= n; ++i) {
            int step = i;
            int max = points[i];
            int point = i;
            while (step++ <= n) {
                for (int j = i; j < step; j++) {
                    if (points[j] > max) {
                        max = points[j];
                        point = j;
                    }
//                    System.out.print(j);
                }
                map.put(point, map.getOrDefault(point, 0) + 1);
//                System.out.println();
            }
        }
        for (int i = 1; i <= n; i++) {
            res[i - 1] = map.get(i);
        }
        return res;
    }
}
