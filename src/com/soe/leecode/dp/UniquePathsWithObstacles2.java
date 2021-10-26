package com.soe.leecode.dp;

public class UniquePathsWithObstacles2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] res = new int[n];
        res[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                    continue;
                }
                if(j >= 1 && obstacleGrid[i][j - 1] == 0) {
                    res[j] += res[j - 1];
                }
            }
        }
        return res[n-1];
    }
}
