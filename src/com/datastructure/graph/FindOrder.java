package com.datastructure.graph;

/**
 * 拓扑排序（topological sort）是一种常见的，对有向无环图排序的算法。给定有向无环图中的
 * N 个节点，我们把它们排序成一个线性序列；若原图中节点 i 指向节点 j，则排序结果中 i 一定在
 * j 之前。拓扑排序的结果不是唯一的，只要满足以上条件即可。
 */

import java.util.*;

/**
 * 我们可以先建立一个邻接矩阵表示图，方便进行直接查找。这里注意我们将所有的边反向，
 * 使得如果课程 i 指向课程 j，那么课程 i 需要在课程 j 前面先修完。这样更符合我们的直观理解。
 * 拓扑排序也可以被看成是广度优先搜索的一种情况：我们先遍历一遍所有节点，把入度为 0
 * 的节点（即没有前置课程要求）放在队列中。在每次从队列中获得节点时，我们将该节点放在目
 * 前排序的末尾，并且把它指向的课程的入度各减 1；如果在这个过程中有课程的所有前置必修课
 * 都已修完（即入度为 0），我们把这个节点加入队列中。当队列的节点都被处理完时，说明所有的
 * 节点都已排好序，或因图中存在循环而无法上完所有课程
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new HashSet<>();
        }

        //[1, 0]  0 -> 1 0为1的先导课程
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++; // 前导课程入度+1
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int count = 0; // 当前结果集中元素的个数，也正好可以当作下标

        while (!q.isEmpty()) {
            Integer head = q.poll();
            res[count++] = head;

            HashSet<Integer> successors  = adj[head]; //可以进行的下一次科目的集合
            for (Integer nextCourse : successors) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    q.offer(nextCourse);
                }
            }
        }

        // 如果结果集中的数量不等于结点的数量，就不能完成课程任务，这一点是拓扑排序的结论
        if (count == numCourses) return res;

        return new int[0];
    }
}
