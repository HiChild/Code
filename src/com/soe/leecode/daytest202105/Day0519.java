package com.soe.leecode.daytest202105;

import java.util.PriorityQueue;

/**
 * 1738. 找出第 K 大的异或坐标值
 *
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Day0519 {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k,(a, b)->a - b);
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] ^ sum[i][j - 1] ^ sum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                if (heap.size() < k) {
                    heap.offer(sum[i][j]);
                } else {
                    if (heap.peek() < sum[i][j]) {
                        heap.poll();
                        heap.offer(sum[i][j]);
                    }
                }
            }
        }
        return heap.peek();
    }
}
