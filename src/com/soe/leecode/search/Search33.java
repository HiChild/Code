package com.soe.leecode.search;

public class Search33 {
    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1,mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                //右边有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                //左边有序
                if (nums[left] < target && target <= nums[mid]) {
                    right = mid - 1;
                }else {
                    left = left + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = search(new int[]{3, 5 ,1}, 3);
        System.out.println(search);
    }
}
