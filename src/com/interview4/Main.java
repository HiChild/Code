package com.interview4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; ++i) {
//            int temp = sc.nextInt();
//            nums[i] = helper(temp);
//        }
//        for (int x : nums) {
//            System.out.println(x);
//        }

        int a = (int) Math.pow(10,9);
//        int sum = helper(a);
//        System.out.println(sum);
//        boolean b = is2(1);
//        System.out.println(b);
        int helper = helper(1001);
        System.out.println(helper);

    }

    private static int helper(int n) {
        int find = find(n);
        int len = helper2(find);
        Map<Integer, Integer> map = new HashMap<>();
        int temp = find;
        while (temp != 0) {
            int mask = (int)Math.pow(2, helper2(temp)) - 1;
            map.put(temp, (temp | mask));
            temp = temp >> 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            int mask = (i & (-i));
            sum += map.get(mask);
        }
        return sum;
    }

    private static int find(int n) {
        while (n > 0) {
            if (is2(n)) return n;
            n--;
        }
        return 0;
    }

    private static int helper2(int mask) {
        int count = 0;
        while (mask != 0) {
            mask /= 2;
            count++;
        }
        return count;
    }

    public static boolean is2(int n) {
        return (n & (- n)) == n;
    }
}
