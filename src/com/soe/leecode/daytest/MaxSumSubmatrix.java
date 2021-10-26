package com.soe.leecode.daytest;

import java.util.TreeSet;

//363. 矩形区域不超过 K 的最大数值和
public class MaxSumSubmatrix {
    /**
     * 暴力法 枚举每一个子矩阵
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        //初始化
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][ j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        //遍历每一个子矩阵 左上角为 i,j 右下角为p,q
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int p = i; p <= m; ++p) {
                    for (int q = j; q <= n; ++ q) {
                        int curr = sum[p][q] - sum[p][j - 1] - sum[i - 1][q] + sum[i - 1][j - 1];
                        if (curr <= k) {
                            max = Math.max(max, curr);
                        }
                    }
                }
            }
        }
        return max;
    }


    /**
     * 优化1
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        //预处理前缀和
        int[][] sum = new int[m + 1][n + 1];
        //下标从1开始
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        //遍历子矩阵的上边界
        for (int top = 1; top <= m; top++) {
            //遍历子矩阵的下边界
            for (int bot = top; bot <= m; bot++) {
                //使用一个有序的存储结构来保存，所有遍历到的右边界
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                //遍历子矩阵的右边界
                for (int r = 1; r <= n; ++r) {
                    //通过前缀和计算right
                    int right = sum[bot][r] - sum[top - 1][r];
                    //通过二分查找left
                    //面积right - 面积left 《= k
                    // left >= right - k;
                    Integer left = ts.ceiling(right - k);
                    if (left != null) {
                        int cur = right - left;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(right);
                }
            }
        }
        return ans;
    }


    /**
     * 优化3：让二分法发挥到最大，让最长的最后被固定
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix3(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        //预处理前缀和
        int[][] sum = new int[m + 1][n + 1];
        //下标从1开始
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        //遍历子矩阵的上边界
        boolean isRight = n > m;
        for (int i = 1; i <= (isRight ? m : n); ++i) {
            for (int j = i; j <= (isRight ? m : n); ++j) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int fixed = 1; fixed <= (isRight ? n : m); ++fixed) {
                    int fixedSize = isRight ? sum[j][fixed] - sum[i - 1][fixed] : sum[fixed][j] - sum[fixed][i - 1];
                    Integer another = ts.ceiling(fixedSize - k);
                    if (another != null) {
                        int cur = fixedSize - another;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(fixedSize);
                }
            }
        }
        return ans;
    }
}
