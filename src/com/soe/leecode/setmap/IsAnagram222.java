package com.soe.leecode.setmap;


public class IsAnagram222 {
    // twp loop counter ++ & --
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (char c : sArr) {
            map[c - 'a']++;
        }
        for (char c : tArr) {
            map[c - 'a']--;
        }

        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
