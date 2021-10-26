package com.soe.leecode.testday202109.day21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindNum {

    int a;

    public static void main(String[] args) {
        FindNum findNum = new FindNum();
        int[] index = findNum.findIndex(new int[]{1, 3, 5, 7}, 6);
        System.out.println(Arrays.toString(index));
        int[] a = new int[]{1,2,3,4,5};
    }

    public int[] findIndex(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    static void test() {

    }
}
