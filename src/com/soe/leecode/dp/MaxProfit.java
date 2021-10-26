package com.soe.leecode.dp;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;

        int[][] dp = new int[len][2]; //第一维表示第几天；第二维 0表示今天操作完没有股票，1表示今天操作完有股票

        //定义第一天的初始状态。
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //从第二天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);//dp[i-1][0] - prices[i]注意这里不能这样，这样的意思为可以进行多次交易，而题目中的意思为只能进行一次交易。
        }
        return dp[len - 1][0];
    }

    /**
     *
     * 空间优化
     * public int maxProfit(int[] prices) {
     *         int len = prices.length;
     *         if (len < 2) {
     *             return 0;
     *         }
     *
     *         int[][] dp = new int[2][2];
     *         dp[0][0] = 0;
     *         dp[0][1] = -prices[0];
     *         for (int i = 1; i < len; i++) {
     *             dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
     *             dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], -prices[i]);
     *         }
     *         return dp[(len - 1) & 1][0];
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
