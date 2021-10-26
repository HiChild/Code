package com.soe.leecode.search;

public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        int left = 0,right = array.length - 1,mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid == target) return mid;
            else if (array[mid] < target) {
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
}
