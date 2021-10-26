package com.soe.leecode.testday202108.day31;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;

/**
 * leecode 81
 */
public class Search {
    static int[]  sortedArray = {
        2,5,6,0,0,1,2
    };

    static int myTarget = 0;

    public static void main(String[] args) {
        System.out.println();
    }

    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right ) {
            mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[mid] <= nums[right]){
                //右区间连续
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                //左区间连续
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
