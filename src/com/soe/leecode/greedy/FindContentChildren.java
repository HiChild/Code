package com.soe.leecode.greedy;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChild = g.length;
        int numOfCookies = s.length;
        int res = 0;
        for (int i = 0, j = 0; i < numOfChild && j < numOfCookies;i++,j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }
            if (j < numOfCookies) {
                res++;
            }
        }
        return res;
    }
}
