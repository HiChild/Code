package com.daily;

import java.util.Arrays;

public class QuickSort {
    static int[] nums = {1,83,8,4,56,7,2,6,6};

    public static void main(String[] args) {
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = getPivot(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private static int getPivot(int[] nums, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; ++i) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[i]; nums[i] = nums[counter]; nums[counter] = temp;
                counter++;
            }
        }
        int temp = nums[pivot]; nums[pivot] = nums[counter]; nums[counter] = temp;
        return counter;
    }


}
