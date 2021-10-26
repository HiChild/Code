package com.interview5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 闪电链
 */
public class Main4 {

    static int cnt = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; ++i) {
//            nums[i] = sc.nextInt();
//        }
//        helper(nums, 0);
//        if (n <= 0) System.out.println(0);
//            System.out.println(cnt);
        int link = link(new int[]{1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,3,8,9});
        System.out.println(link);
    }

    private static int link(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != 0) {
                helper(nums, i);
                count++;
                String string = Arrays.toString(nums);
                System.out.println(string);
            }
        }
        return count;
    }

    private static void helper(int[] nums, int i) {
        for (int j= i; j < nums.length; ++j) {
            if (nums[j] == 0) {
                return;
            }
            nums[j]--;
        }
    }
}
