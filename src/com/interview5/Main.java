package com.interview5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int res1 = helper1(str);
        int res2 = helper2(str);
        int res = Math.min(res1, res2);

        System.out.println(res);
    }

    private static int helper1(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 1; i < chars.length; ++i) {
            int pos = (int)chars[i];
            if (pos >= 97) {
                if (chars[i] == chars[i - 1]) {
                    chars[i] = (char) (chars[i] - 32);
                    count++;
                }
            } else {
                if (chars[i] == chars[i - 1]) {
                    chars[i] = (char) (chars[i] + 32);
                    count++;
                }
            }
        }
        return count;
    }
    private static int helper2(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length - 1; ++i) {
            int pos = (int)chars[i];
            if (pos >= 97) {
                if (chars[i] == chars[i + 1]) {
                    chars[i] = (char) (chars[i] - 32);
                    count++;
                }
            } else {
                if (chars[i] == chars[i + 1]) {
                    chars[i] = (char) (chars[i] + 32);
                    count++;
                }
            }
        }
        return count;
    }
}


//        System.out.println((int)'A');//65
//        System.out.println((int)'a');//97