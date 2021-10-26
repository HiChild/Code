package com.soe.leecode.daytest;

/**
 * 28 kmp算法
 */
public class StrStr {

    /**
     * KMP
     */
    //ss 原串 pp目标串
    public int strStrKMP(String ss, String pp) {
        if (pp.length() == 0) return 0;
        //分别读取原串和目标串的长度
        int n = ss.length(), m = pp.length();
        //特殊： 源串和目标串前面都加空格，使其下标从1开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        //构建next数组， 数组长度为匹配串的长度
        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; ++i) {
            //匹配不成功的话 j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            //匹配成功的话，先让j++
            if (p[i] == p[j+1]) j++;
            //更新next（i）
            next[i] = j;
        }

        // 匹配过程 i = 1, j = 0开始
        for (int i = 1, j = 0; i <= n; ++i) {
            //匹配不成功 j = next[j]
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            //匹配成功的话 先让j++
            if (s[i] == p[j + 1]) j++;
            //如果一整段都匹配的话，直接返回下标
            if (j == m) return i - m;

        }
        return -1;
    }


    //暴力法 n^2
    public int strStr(String haystack, String needle) {

        if (needle.equals("")) return 0;
        int n = haystack.length();
        int k = needle.length();
        for (int i = 0; i < n - k + 1; ++i) {
            int start = i;
            boolean fg = true;
            int count = 0;
            while(count < k) {
                if (haystack.charAt(start++) != needle.charAt(count++)) {
                    fg = false;
                }
            }
            if (fg) return i;
        }
        return -1;
    }


    /**
     * 使用内置函数
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        return     haystack.indexOf(needle);
    }

    /**
     * 暴力法 简化版本
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int n = haystack.length();
        int k = needle.length();
        for (int i = 0; i <= n - k ; ++i) {
            int start = i;
            int count = 0;
            while(count < k && haystack.charAt(start) == needle.charAt(count)) {
                start++;
                count++;
            }
            if (count == k) return i;
        }
        return -1;
    }




}
