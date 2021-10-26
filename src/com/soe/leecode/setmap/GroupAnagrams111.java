package com.soe.leecode.setmap;

import java.util.*;

public class GroupAnagrams111 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String key = String.valueOf(sArr);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
