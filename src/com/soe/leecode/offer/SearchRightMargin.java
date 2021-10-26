package com.soe.leecode.offer;

public class SearchRightMargin {
    public static int  search(int[] nums, int target) {
        return getRightMargin(nums, target) - getRightMargin(nums, target - 1);
    }
    static int getRightMargin(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int search = search(new int[]{7, 7, 8, 8, 10}, 12);
        System.out.println(search);
    }
}
