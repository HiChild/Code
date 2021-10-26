package com.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 在一场持续300分钟的算法竞赛中，小美在75分钟后便没有了提交。而在不久之后的另一场比赛中，小美225分钟后便没有了提交。于是被小团调侃用一场比赛的时间打了两场比赛。
 *
 *        小团打了n场比赛，每场比赛持续时间为m分钟，第i场比赛中，小团ai分钟后便没有了提交。请统计，有多少无序对(i,j)满足ai+aj≤m，以方便小美来调侃小团。
 */
public class Main3 {
    //第一行两个正整数n,m(1≤n≤5x104，1≤m≤109)。
    //
    //第二行n个正整数a1,a2,......,an（1≤ai≤109）。
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] times = new int[n];
//        for (int i = 0; i < n; ++i) {
//            times[i] = sc.nextInt();
//        }
//        int res = help(n, m, times);
//        System.out.println(res);
        int i = (int) (1.5 % 1);
        System.out.println(i);
    }

    private static int help(int n, int m, int[] times) {
        int count = 0;
        Arrays.sort(times);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (times[i] + times[j] <= m) {
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
}
