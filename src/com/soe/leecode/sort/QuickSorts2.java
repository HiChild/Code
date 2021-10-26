package com.soe.leecode.sort;

import java.util.Arrays;

/**
 * 左闭右闭的快速排序的两种实现方式
 */
public class QuickSorts2 {

    static int[] testArray = {
            2,5,3,6,88,9,5,7,4
//            2,5,3,4x`
    };

    public static void main(String[] args) {
        QuickSorts2 quickSorts = new QuickSorts2();
        quickSorts.sort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    private void sort(int[] testArray) {
        quickSort(testArray, 0, testArray.length - 1);
    }

    public void quickSort (int[] testArray, int begin, int end) {
        if (begin >= end) return;
        int pivot = getPivot(testArray, begin, end);
        quickSort(testArray, begin, pivot - 1);
        quickSort(testArray, pivot + 1, end);
    }

    private int getPivot(int[] testArray, int begin, int end) {
        int pivot = end, counter = begin;
        for (int i = begin; i < end; ++i) {
            if (testArray[i] <= testArray[pivot]) {
                int temp = testArray[counter]; testArray[counter] = testArray[i]; testArray[i] = temp;
                counter++;
            }
        }
        int temp = testArray[counter]; testArray[counter] = testArray[pivot]; testArray[pivot] = temp;
        return counter;
    }

}

