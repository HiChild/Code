package com.soe.leecode.setmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams22 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String Key = String.valueOf(ca);
            if (!ans.containsKey(Key)) ans.put(Key, new ArrayList<>());
            ans.get(Key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
