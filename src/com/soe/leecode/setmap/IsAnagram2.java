package com.soe.leecode.setmap;

import java.util.Arrays;

public class IsAnagram2 {
    //counter ++ & --
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
//        for (int count : map) {
//            if (count != 0) {
//                return false;
//            }
//        }
        for (int i = 0; i < map.length; i++) {
            System.out.println("m[" + i + "]: " + map[i]);
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram2 isAnagram = new IsAnagram2();
        boolean f = isAnagram.isAnagram("nl", "cx");
        System.out.println(f);


    }
}
