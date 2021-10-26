package com.interview5;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int res = helper(str.toCharArray(), 0, 1);

        System.out.println(res);
    }

    private static int helper(char[] chars, int i, int step) {
        if (i == chars.length - 2) return step;
        int pos1 = (int)chars[i];
        int pos2 = (int)chars[i + 1];
        int min = step;
        if (chars[i] == chars[i + 1]) {
            chars[i] = (char) (chars[i] >= 97 ? chars[i] - 32 : chars[i] + 32);
            int step1 = helper(chars, i + 1, step + 1);
            chars[i] = (char) pos1;
            chars[i + 1] = (char) (chars[i + 1] >= 97 ? chars[i + 1] - 32 : chars[i + 1] + 32);
            int step2 = helper(chars, i + 1, step + 1);
            min = Math.min(step1, step2);
            chars[i + 1] = (char) pos2;
        }
        return min;
    }

//aaAaabbb
}


//        System.out.println((int)'A');//65
//        System.out.println((int)'a');//97