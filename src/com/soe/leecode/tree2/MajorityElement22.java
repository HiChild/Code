package com.soe.leecode.tree2;

public class MajorityElement22 {
//    public int majorityElement(int[] nums) {
//        int count = 0;
//        int pre = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (count == 0) {
//                pre = nums[i];
//            }
//            if (nums[i] == pre) count++;
//            if (nums[i] != pre) count--;
//        }
//        return pre;
//    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int pre = 0;
        for (int num : nums) {
            if (count == 0) {
                pre = num;
            }
            count += count == pre ? 1 : -1;
        }
        return pre;
    }


    public static void main(String[] args) {
        MajorityElement22 majorityElement = new MajorityElement22();
        int res = majorityElement.majorityElement(new int[]{3, 3, 2, 3, 3, 2, 2, 2});
        System.out.println(res);
    }
}
