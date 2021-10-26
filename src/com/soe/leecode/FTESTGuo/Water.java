package com.soe.leecode.FTESTGuo;

import java.util.Arrays;
import java.util.Scanner;

public class Water {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 2];
        for (int i = 1; i <= n; ++i) {
            nums[i] = sc.nextInt();
        }
        nums[0] = Integer.MAX_VALUE;
        nums[n + 1] = Integer.MAX_VALUE;
        int num = getNum(n, nums);
        System.out.println(num);

    }

    public static int getNum(int n, int[] nums) {
        int[] dp = new int[n + 2];
        Arrays.fill(dp, 1);
        dp[0] = 0; dp[n + 1] = 0;
        int max = 0;
        for (int i = 1; i <= n; ++i) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i] + dp[i - 1];
            }
            if (nums[i] > nums[i + 1]) {
                dp[i] = dp[i] + dp[i + 1];
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
