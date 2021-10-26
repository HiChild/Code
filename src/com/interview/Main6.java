package com.interview;

public class Main6 {
    public static void main(String[] args) {
        int n = 3;
        int[][] res = new int[n][n];
        for (int i = 0 ; i < n; ++i) {
            int step = i;
            while (step++ < n) {
                for (int k = i; k < step; ++k) {
                    System.out.print(k);
                }
                System.out.println();
            }
        }
    }
}
