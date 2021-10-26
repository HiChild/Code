package com.soe.leecode.tree2;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement1111 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 1) + 1);
        }
        int key = 0;
        int pre = 0;
        for (int num : nums) {
            int count = map.get(num);
            if (count > pre) {
                pre = count;
                key = num;
            }
        }
        return key;
    }

    public static void main(String[] args) {
        MajorityElement1111 majorityElement = new MajorityElement1111();
        int res = majorityElement.majorityElement(new int[]{3, 3, 2});
        System.out.println(res);
    }
}
