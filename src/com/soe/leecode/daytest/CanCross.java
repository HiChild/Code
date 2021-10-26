package com.soe.leecode.daytest;

import java.util.HashMap;
import java.util.Map;

public class CanCross {
    //需要一个来存储下标和其值的hashmap
    Map<Integer, Integer> map = new HashMap<>();
    //需要一个数据结构来记忆化我们的结果
    Map<String, Boolean> cache = new HashMap<>();
    public boolean canCross(int[] ss) {
        int n = ss.length;
        for (int i = 0; i < n; ++i) {
            map.put(ss[i], i);
        }

        if(!map.containsKey(1)) return false;
        return dsf(ss, n, 1, 1);
    }

    public boolean  dsf(int[] ss,int n,int idx, int step) {
        String key = idx + "_" + step;
        if (cache.containsKey(key)) return cache.get(key);
        if (idx == n - 1) return true;
        for (int i = -1; i <= 1; ++i) {
            if (i + step == 0) continue;
            int next = step + i + ss[idx];
            if (map.containsKey(next)) {
                boolean cur = dsf(ss, n,map.get(next), step + i);
                cache.put(key, cur);
                if (cur) return true;
            }
        }
        cache.put(key,false);
        return false;
    }

    public static void main(String[] args) {
    }
    
}
