package com.soe.leecode.string;

public class subStringOrder {

    private static int subString(String s1, String s2) {
        int[][] res = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ( s1.charAt(i - 1) == s2.charAt(j - 1) ) {
                    res[i][j] = 1 + res[i - 1][j - 1];
                }else{
                    res[i][j] = Math.max(res[i - 1][j],res[i][j - 1]);
                }
            }
        }
        return res[s1.length()][s2.length()];
    }
}
