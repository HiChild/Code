package com.soe.leecode.tree2;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement11 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1) + 1);
        }
        int key = 0;
        int max = -Integer.MAX_VALUE;
        for (int num : nums) {
            int count = map.get(num);
            if (count > max) {
                key = num;
                max = count;
            }
        }
        return key;
    }

    public static void main(String[] args) {
        MajorityElement11 majorityElement = new MajorityElement11();
        int res = majorityElement.majorityElement(new int[]{3, 3, 2});
        System.out.println(res);
    }
}
