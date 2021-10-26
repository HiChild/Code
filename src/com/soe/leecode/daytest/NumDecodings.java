package com.soe.leecode.daytest;

/**
 * 91 解码方法
 */
public class NumDecodings {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n = s.length();
        //" "作为哨兵 设置哨兵可以让我们的数组下标从1开始，还可以防止前导0
        s = " " + s;
        char[] c = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            //a 是只能当前 b是只能合并
            int a = c[i] - '0', b = (c[i - 1] - '0') * 10 + (c[i] - '0');
            if (1 <= a && a <= 9 ) {
                f[i] = f[i - 1];
            }
            if (10 <= b && b <= 26) {
                f[i] += f[i-2];
            }
        }
        return f[n];
    }


    /**
     * 滚动数组优化空间复杂度
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        int n = s.length();
        //" "作为哨兵 设置哨兵可以让我们的数组下标从1开始，还可以防止前导0
        s = " " + s;
        char[] c = s.toCharArray();
        int[] f = new int[3];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            f[i % 3] = 0;
            int a = c[i] - '0', b = (c[i - 1] - '0') * 10 + (c[i] - '0');
            if (1 <= a && a <= 9 ) {
                f[i % 3] = f[(i - 1) % 3];
            }
            if (10 <= b && b <= 26) {
                f[i % 3] += f[(i-2)%3];
            }
        }
        return f[n%3];
    }

}
