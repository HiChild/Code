package com.soe.leecode.setmap;

import java.util.*;

public class GroupAnagrams11 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String Key = String.valueOf(sArr);
            if (!ans.containsKey(Key)) ans.put(Key, new ArrayList<>());
            ans.get(Key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
