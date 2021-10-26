package com.soe.leecode.setmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams2222 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ca = new char[26];
            for (char c : str.toCharArray()) {
                ca[c - 'a']++;
            }
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
