package com.soe.leecode.setmap;

public class IsAnagram33 {
    //counter ++ & --
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < t.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
