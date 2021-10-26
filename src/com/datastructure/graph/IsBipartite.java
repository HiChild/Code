package com.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class IsBipartite {
    /**
     二分图算法也称为染色法，是一种广度优先搜索。如果可以用两种颜色对图中的节点进行着
     色，并且保证相邻的节点颜色不同，那么图为二分。

     利用队列和广度优先搜索，我们可以对未染色的节点进行染色，并且检查是否有颜色相同的
     相邻节点存在。注意在代码中，我们用 0 表示未检查的节点，用 1 和 2 表示两种不同的颜色。
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        if (n == 0) return true;
        int[] color = new int[n]; //0表示为检验，1，2表示两种颜色
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (color[i] == 0) {
                queue.offer(i);
                color[i] = 1;
            }
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int j : graph[node]) {
                    if (color[j] == 0) {
                        queue.offer(j);
                        color[j] = color[node] == 2 ? 1 : 2;
                    } else if(color[j] == color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
