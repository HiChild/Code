package com.soe.leecode.offer;

import java.util.Arrays;

public class ReverseLeftWords {
    public static String reverseLeftWords(String s, int n) {
        if (n <= 0 || n % s.length() == 0) return s;
        n = n % s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            sb.append(c);
        }
        return sb.toString().substring(n);

    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg",2));
    }
}
