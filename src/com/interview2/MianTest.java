package com.interview2;

import java.util.Arrays;
import java.util.Scanner;

public class MianTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] res =new char[m][n];
        for (int i = 0; i < m; ++i) {
            String s = sc.next();
            res[i] = s.toCharArray();
        }
        System.out.println(Arrays.toString(res[0]));
        System.out.println(Arrays.toString(res[1]));
    }
}
