package com.soe.leecode.testday202109.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * leecode 417
 */
public class PacificAtlantic {

    private static int[] position = {-1, 0 ,1 ,0, -1};

    private static int[][] island = {
        {1,2,2,3,5},
        {3,2,3,4,4},
        {2,4,5,3,1},
        {6,7,1,4,5},
        {5,1,1,2,4}
    };

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        List<List<Integer>> lists = pacificAtlantic.pacificAtlantic(island);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights.length == 0 || heights[0].length == 0) return res;
        int m = heights.length,n = heights[0].length;
        boolean[][] canGoTo_p = new boolean[m][n];
        boolean[][] canGoTo_a = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            //可以到达太平洋
            dsf(heights, canGoTo_p, i, 0);
            //可以到达大西洋
            dsf(heights, canGoTo_a, i, n - 1);
        }

        for (int i = 0; i < n; ++i) {
            //可以到达太平洋
            dsf(heights, canGoTo_p, 0, i);
            //可以到达大西洋
            dsf(heights, canGoTo_a, m - 1, i);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (canGoTo_a[i][j] && canGoTo_p[i][j]) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void dsf(int[][] heights, boolean[][] canGoTo, int r, int c) {
        if (canGoTo[r][c]) return;
        canGoTo[r][c] = true;
        int x, y;
        for (int i = 0; i < 4; ++i) {
            x = position[i] + r;
            y = position[i + 1] + c;
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length
                && heights[r][c] <= heights[x][y]) {
                dsf(heights, canGoTo, x, y);
            }
        }
    }
}
