package com.soe.leecode.offer;

public class MinArray {
    public static int minArray1(int[] numbers) {
        int left = -1, right = numbers.length - 1,mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            }else if (numbers[mid] > numbers[right]){
                left = mid + 1;

            }else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int i = minArray1(new int[]{0,2,3,7,8,1,2,6});
        System.out.println(i);
    }
}
