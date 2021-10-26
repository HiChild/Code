package com.interview3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int help = help(arr, n);
        System.out.println(help);
    }

    private static int help(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (arr[i] < arr[j] && arr[j] < arr[k]) {
                        max = Math.max(max, arr[i] + arr[j] + arr[k]);
                    }
                }
            }
        }
        return max;
    }
}
