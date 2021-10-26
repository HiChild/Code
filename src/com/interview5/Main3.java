package com.interview5;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ins = new int[m];
        int[] outs = new int[m];
        for (int i = 0; i < m; ++i) {
            ins[i] = sc.nextInt();
        }
        for (int i = 0 ; i <m; ++i) {
            outs[i] = sc.nextInt();
        }
        int res = help(ins, outs, n);
        System.out.println(res);
    }

    private static int help(int[] ins, int[] outs, int n) {
        Arrays.sort(ins);
        Arrays.sort(ins);
        if (n <= 0 || ins.length <= 0) return 0;
        int s = ins[0], e = outs[0];
        int sum = 0;
        for (int i = 1; i < ins.length; ++i) {
            if (outs[i] >= n || ins[i] >= n) return 0;
            if (ins[i] > e) {
                sum += e - s;
                s = ins[i];
                e = outs[i];
            } else {
                s = Math.min(ins[i], s);
                e = Math.max(outs[i], e);
            }
        }
        sum += e - s;
        return n - sum - 1;
    }
}
