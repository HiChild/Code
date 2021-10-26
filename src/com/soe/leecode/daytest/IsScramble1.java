package com.soe.leecode.daytest;

import java.util.HashSet;
import java.util.Set;

public class IsScramble1 {
    public static boolean isScramble(String s1, String s2) {
        //两字符串相等或者 字符串的词频不同作为递归的出口
        if (s1.equals(s2)) return true;
        if (!check(s1,s2)) return false;
        int n = s1.length();
        for (int i = 1; i < n; ++i) {
            //s1分割为[0,i)和[i,n)两部分
            String a = s1.substring(0, i), b = s1.substring(i);
            //s2由两种可能
            //1. [0,i)和[i,n)两部分
            String c = s2.substring(0, i), d = s2.substring(i);
            if (isScramble(a, c) && isScramble(b, d)) return true;
            //2. [0,n - i)和[n - i,n)两部分  //这一步太巧妙了！！！！！！！！！！！
            String e = s2.substring(0, n - i), f = s2.substring(n - i);
            if (isScramble(a, f) && isScramble(b, e)) return true; //因为是交换过的所以顺序不一样
        }
        return false;
    }

    private static boolean check(String s1, String s2) {
        int[] cnt = new int[26];
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        for (int i : cnt) {
            if (i != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
    }
}
