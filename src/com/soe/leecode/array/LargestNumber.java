package com.soe.leecode.array;

import java.util.*;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int num : nums)  res.add(String.valueOf(num));
        res.sort((s1,s2) -> (s2 + s1).compareTo(s1 + s2));
        for (String str : res) sb.append(str);
        for (int i = 0; sb.charAt(i) == '0' && i<sb.length() - 1;) sb.deleteCharAt(i);

        return sb.toString();
    }

    public static void main(String[] args) {
        largestNumber(new int[]{0,0,1,0,});
    }
}
