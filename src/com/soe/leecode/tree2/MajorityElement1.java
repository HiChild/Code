package com.soe.leecode.tree2;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement1 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -Integer.MAX_VALUE;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1) + 1);
        }
        int key = 0;
        for (int num : nums) {
            int count = map.get(num);
            System.out.println(map.get(num) + "count =" + count);
            if (count > max) {
                max = count;
                key = num;
            }
        }
        return key;
    }

    public static void main(String[] args) {
        MajorityElement1 majorityElement = new MajorityElement1();
        int res = majorityElement.majorityElement(new int[]{3, 3, 2});
        System.out.println(res);
    }
}
