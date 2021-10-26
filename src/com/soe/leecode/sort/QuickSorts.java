package com.soe.leecode.sort;

import java.util.Arrays;

/**
 * 左闭右闭的快速排序的两种实现方式
 */
public class QuickSorts {

    static int[] testArray = {
            2,5,3,6,88,9,5,7,4
//            2,5,3,4x`
    };

    public static void main(String[] args) {
        QuickSorts quickSorts = new QuickSorts();
        quickSorts.sort(testArray);
        System.out.println(Arrays.toString(testArray));
    }





    public void sort(int[] nums) {
        //实现方式1
//        quickSort1(nums, 0, nums.length - 1);
        //实现方式2
        quickSort2(nums, 0, nums.length - 1);
    }



    /**
     * 左闭右闭，递归写法1；选取最后一个元素为分界点;
     * @param nums
     * @param begin
     * @param end
     */
    private void quickSort1(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int pivot = getPivot(nums, begin, end);
        quickSort1(nums, begin, pivot - 1);
        quickSort1(nums, pivot + 1, end);
    }

    private int getPivot(int[] nums, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; ++i) {
            if (nums[i] < nums[pivot]) {
                int temp = nums[i]; nums[i] = nums[counter]; nums[counter++] = temp;
            }
        }
        int temp = nums[counter]; nums[counter] = nums[pivot]; nums[pivot] = temp;
        return counter;
    }

    /**
     * 左闭右闭，递归写法2；选取第1个元素为临界点;
     * @param nums
     * @param begin
     * @param end
     */
    private void quickSort2(int[] nums, int begin, int end) {
        if (begin >= end) return;
        int first = begin, last = end, key = nums[first];
        while (first < last) {
            while (first < last && nums[last] >= key) {
                last--;
            }
            nums[first] = nums[last];
            while (first < last && nums[first] <= key) {
                first++;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        quickSort2(nums, begin, first - 1);
        quickSort2(nums, first + 1, end);
    }



}

