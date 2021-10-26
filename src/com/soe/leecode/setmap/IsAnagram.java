package com.soe.leecode.setmap;

import java.util.Arrays;

public class IsAnagram {
    //violent
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        boolean f = isAnagram.isAnagram("anagram", "nagaram");
        System.out.println(f);


    }
}
