package com.soe.leecode.sort;

import java.util.Arrays;

public class QuickSorts3 {
    static int[] testArray = {
            2,5,3,6,88,9,5,7,4
//            2,5,3,4x`
    };

    public static void main(String[] args) {
        quickSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    
    private static void quickSort(int[] nums, int begin, int end) {
        if (begin > end) return;
        int pivot = getPivot(nums, begin, end);
        quickSort(nums, 0, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private static int getPivot(int[] nums, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < nums.length; ++i) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[i]; nums[i] = nums[counter]; nums[counter++] = temp;
            }
        }
        int temp = nums[counter]; nums[counter] = nums[pivot]; nums[pivot] = temp;
        return counter;
    }
}
