package com.soe.leecode.offer;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1,mid;
        while (left <= right) {
            mid = left + (right - left)/2;
            if (nums[mid] == mid) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        return left;
    }
}
