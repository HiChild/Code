package com.soe.leecode.testday202109.day02;

public class FindCircleNum {

    static int[][] test = {

            {1,1,0},
            {1,1,0},
            {0,0,1}
    };

    public static void main(String[] args) {
        test();
    }

    public static void test () {
        FindCircleNum findCircleNum = new FindCircleNum();
        int res = findCircleNum.findCircleNum(test);
        System.out.println(res);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visit[i]) {
                dsf(isConnected, i , visit);
                ++count;
            }
        }
        return count;
    }

    private void dsf(int[][] isConnected, int i, boolean[] visit) {
        visit[i] = true;
        for (int k = 0; k < isConnected.length; ++k) {
            if (isConnected[i][k] == 1 && !visit[k]) {
                dsf(isConnected, k, visit);
            }
        }
    }
}
