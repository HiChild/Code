package com.interview2;

import java.util.Stack;

public class BitCount {
    public static void main(String[] args) {
        countBits(2);
    }

    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            dp[i] = ((i & 1) == 1 ? dp[i - 1] + 1 : dp[i >> 1]);
        }
        Stack s = new Stack();
        return dp;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty()) {
                int pre_pos = stack.peek();
                if (temperatures[i] <= temperatures[pre_pos]) {
                    break;
                }
                stack.pop();
                res[pre_pos] = i - pre_pos;
            }
            stack.push(i);
        }
        return res;
    }
}
