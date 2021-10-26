package com.soe.leecode.daytest;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class NumMatrix {
    /**
     * 二维矩阵前缀和
     * @param matrix
     */
    int[][] sum ;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        sum = new int[m + 1][n + 1];
        //初始化
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //因为我们下标是从1开始的
        row1++;row2++;col1++;col2++;
        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }


    /**
     * 二维前缀和模板
     */
//    // 预处理前缀和数组
//    {
//        sum = new int[n + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                // 当前格子(和) = 上方的格子(和) + 左边的格子(和) - 左上角的格子(和) + 当前格子(值)【和是指对应的前缀和，值是指原数组中的值】
//                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
//            }
//        }
//    }
//
//    // 首先我们要令左上角为 (x1, y1) 右下角为 (x2, y2)
//// 计算 (x1, y1, x2, y2) 的结果
//    {
//        // 前缀和是从 1 开始，原数组是从 0 开始，上来先将原数组坐标全部 +1，转换为前缀和坐标
//        x1++; y1++; x2++; y2++;
//        // 记作 22 - 12 - 21 + 11，然后 不减，减第一位，减第二位，减两位
//        // 也可以记作 22 - 12(x - 1) - 21(y - 1) + 11(x y 都 - 1)
//        ans = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
//    }


}
