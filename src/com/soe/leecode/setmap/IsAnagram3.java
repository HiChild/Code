package com.soe.leecode.setmap;

public class IsAnagram3 {
    //counter ++ & --
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
            if (map[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram3 isAnagram = new IsAnagram3();
        boolean f = isAnagram.isAnagram("nl", "cx");
        System.out.println(f);


    }
}
