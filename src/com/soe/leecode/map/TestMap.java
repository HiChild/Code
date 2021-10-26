package com.soe.leecode.map;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {

        int i = singleNumber(new int[]{2, 3, 3, 3});
        System.out.println(i);
    }


    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (int num : nums) {
            int count = map.get(num);
            if (count == 1)
                return num;
        }
        return -1;
    }
}
