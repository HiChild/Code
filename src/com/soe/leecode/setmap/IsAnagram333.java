package com.soe.leecode.setmap;

public class IsAnagram333 {
    //counter ++ & --
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) map[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) map[t.charAt(i) - 'a']--;
        for (int i : map) if (i != 0) return false;
        return true;
    }
}
