package com.soe.leecode.dp;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] res = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    res[i][j] = res[i-1][j-1] + 1;
                }else{
                    res[i][j] = Math.max(res[i][j-1],res[i-1][j]);
                }
            }
        }
        return res[m][n];
    }
}
