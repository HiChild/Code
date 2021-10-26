package com.soe.leecode.testday202109.day02;

import java.util.Stack;

/**
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {
    static int[] direction = {-1, 0, 1, 0, -1};

    static int[][] test = {
//            {0,0,1,0,0,0,0,1,0,0,0,0,0},
//            {0,0,0,0,0,0,0,1,1,1,0,0,0},
//            {0,1,1,0,1,0,0,0,0,0,0,0,0},
//            {0,1,0,0,1,1,0,0,1,0,1,0,0},
//            {0,1,0,0,1,1,0,0,1,1,1,0,0},
//            {0,0,0,0,0,0,0,0,0,0,1,0,0}

//            {1,0,1},
//            {1,1,1},
//            {1,0,0}
            {1,1},
            {1,0}
    };

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        maxAreaOfIsland.test01(test);
    }
    public void test01(int[][] grid) {
        int res = maxAreaOfIsland2(grid);
        System.out.println(res);
    }

    /**
     * 栈写法
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid.length == 0 ? 0 : grid[0].length;
        int maxArea = 0, localArea = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    localArea = 1;
                    grid[i][j] = 0;
                    int[] pairs = {i, j};
                    stack.push(pairs);
                    while (!stack.isEmpty()) {
                        pairs = stack.pop();
                        for (int k = 0; k < 4; ++k) {
                            //pairs在for循环中不能被改变， 进行入栈的时候需要重新建立一个新的数组来保存
                            int x = pairs[0] + direction[k];
                            int y = pairs[1] + direction[k+1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                                localArea++;
                                grid[x][y] = 0;
                                //建立一个新数组来入栈
                                int[] newPairs = {x, y};
                                stack.push(newPairs);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, localArea);
                }
            }
        }
        return maxArea;
    }


    /**
     * 递归写法
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea,dsf(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dsf(int[][] grid, int r, int c) {
        if (grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int area = 1;
        for (int i = 0; i < 4; ++i) {
            int x = r + direction[i];
            int y = c + direction[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1 ) {
                area += dsf(grid, x, y);
            }
        }
        return area;
    }
}
