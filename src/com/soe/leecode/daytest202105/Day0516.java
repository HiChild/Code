package com.soe.leecode.daytest202105;

import java.util.Arrays;

/**
 * 421. 数组中两个数的最大异或值
 * 题解 Trie 字典树 异或
 * 数组实现字典树
 */
public class Day0516 {
    static int N = (int)1e6;
    static int[][] trie = new int[N][2];
    static int idx = 0;

    public Day0516() {
        for (int i = 0; i <= idx; ++i) {
            Arrays.fill(trie[i],0);
        }
        idx = 0;
    }
    //trip保存着下一次可以访问的下标
    void add (int x) {
        int p = 0;
        for (int i = 31; i >= 0; --i) {
            int u = (x >> i) & 1;
            if (trie[p][u] == 0) trie[p][u] = ++idx;
            p = trie[p][u];
        }
    }
    int getVal(int x) {
        int p = 0;
        int ans = 0;
        for (int i = 31; i >= 0; --i) {
            int a = (x >> i) & 1, b = 1 - a;
            if (trie[p][b] != 0) {
                ans |= (b << i);
                p = trie[p][b];
            } else {
                ans |= (a << i);
                p = trie[p][a];
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            add(i);
            int j = getVal(i);
            ans = Math.max(ans, i ^ j);
        }
        return ans;
    }
}
