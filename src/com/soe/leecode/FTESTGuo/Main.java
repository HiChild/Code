package com.soe.leecode.FTESTGuo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; ++i) {
            nums1[i] = sc.nextInt();
            nums2[i] = nums1[i];
        }
        int[] dp1 = getCount(n, nums1);
        int[] dp2 = getCount2(n, nums2);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += Math.min(dp1[i], dp2[i]);
        }
        System.out.println(count);
    }
    private static int[] getCount(int n, int[] nums) {
        int[] dp1 = new int[n];
        for (int i = 1; i < n; ++i) {
            int key = nums[i - 1] - 1;
            int step = Math.max(nums[i] - key, 0);
            if (step > 0) {
                nums[i] -= step;
            }
            dp1[i] = step;
        }
        return dp1;
    }

    private static int[] getCount2(int n, int[] nums) {
        int[] dp1 = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            int key = nums[i + 1] - 1;
            int step = Math.max(nums[i] - key, 0);
            if (step > 0) {
                nums[i] -= step;
            }
            dp1[i] = step;
        }
        return dp1;
    }
}
