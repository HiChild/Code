package com.soe.leecode.setmap;

import java.util.*;

public class GroupAnagrams1111 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
