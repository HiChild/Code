package com.soe.leecode.daytest202105;

/**
 * 1035. 不相交的线
 *
 *
 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。

 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：

 nums1[i] == nums2[j]
 且绘制的直线不与任何其他连线（非水平线）相交。
 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。

 以这种方法绘制线条，并返回可以绘制的最大连线数。
 */
public class Day0521 {
    public int maxUncrossedLines(int[] s1, int[] s2) {
        int n = s1.length, m = s2.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (s1[i - 1] == s2[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        return f[n][m];
    }
}
