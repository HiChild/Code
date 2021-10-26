package com.soe.leecode.testday202109.day17;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 934. 寻找最近岛屿问题---经典
 */
public class ShortestBridge {
    static int[] direction = {-1, 0 ,1 ,0, -1};

    static int[][] test = {
            {0,1,0},
            {0,0,0},
            {0,0,1}
    };

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        ShortestBridge shortestBridge = new ShortestBridge();
        int i = shortestBridge.shortestBridge(test);
        System.out.println(i);
    }

    /**
     * 934 最短的桥
     * @param grid
     * @return
     */
    public int shortestBridge(int[][] grid) {
        //先遍历第一个岛将所有1变为2，并记录相邻的海
        int m = grid.length, n = grid[0].length;
        Deque<int[]> points = new LinkedList<>();
        boolean isFilled = false;
        for (int i = 0; i < m; ++i) {
            if (isFilled) {
                break;
            }
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dsf(grid, points, m, n, i, j);
                    isFilled = true;
                    break;
                }
            }
        }
        //按层遍历，每一次将一层海填入2，并记录新的相邻的海存入points
        int level = 0;
        int x , y;
        while (!points.isEmpty()) {
            int n_points = points.size();
            level++;
            while (n_points-- > 0) {
                int[] point = points.removeFirst();
                //将海修改为陆地
//                grid[point[0]][point[1]] = 2;
                //探测相邻的海
                for (int i = 0; i < 4; ++i) {
                    x = point[0] + direction[i];
                    y = point[1] + direction[i + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (grid[x][y] == 2) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            return level;
                        }
                        if (grid[x][y] == 0) {
                            points.addLast(new int[]{x, y});
                            grid[x][y] = 2;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void dsf (int[][] grid, Deque<int[]> points, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] == 0) {
            //保存和岛屿1相邻的海
            points.addLast(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        dsf(grid, points, m, n, i + 1, j);
        dsf(grid, points, m, n, i - 1, j);
        dsf(grid, points, m, n, i, j + 1);
        dsf(grid, points, m, n, i, j - 1);
    }
}
