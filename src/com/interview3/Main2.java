package com.interview3;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] dp = help(map, n);
        int[] help = new int[n - 1];
        System.arraycopy(dp[dp.length - 2], 1, help, 0, n - 1);
        int max = 0;
        for (int i = 0; i < n - 1; ++i) {
            max = Math.max(max, map[n - 1][i] + help[i]);
        }
        max = Math.max(max, map[n - 1][n - 1]);
        System.out.println(max);
    }

    private static int[][] help(int[][] map, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]) + map[i - 1][j - 1];
            }
        }
        return dp;
    }
}
