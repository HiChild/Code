package com.interview2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] des = {-1, 0, 1, 0, -1};



    public static void main(String[] args) {
//        boolean help = help(test1);
//        System.out.println(help);


        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        List<char[][]> list = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] test = new char[m][n];
            for (int a = 0; a < m; a++) {
                test[a] = sc.next().toCharArray();
            }
            list.add(test);
        }
        for (int i = 0; i < k; ++i) {
            boolean help = help(list.get(i));
            if (help) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    public static boolean help(char[][] graph) {
        if (graph.length == 0 || graph[0].length == 0) return false;
        if (graph.length <= 3 || graph[0].length <= 3) return false;
        int isOKCount = 0;
        int right_i = -1; int right_j = -1;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (isOk(graph, i, j)) {
                    isOKCount++;
                    right_i = i;
                    right_j = j;
                }
                if (isOKCount == 2) return false;
            }
        }
        if (right_i != -1 && right_j != -1) {
            return countStep(graph, right_i, right_j);
        }
        return false;
    }

    public static boolean isOk(char[][] graph,int idx_i, int idx_j) {
        if (graph[idx_i][idx_j] == '.') return false;
        int x, y;
        for (int k = 0; k < 4; ++k) {
            x = idx_i + des[k];
            y = idx_j + des[k + 1];
            if (x >= 0 && x < graph.length && y >= 0 && y < graph[0].length) {
                if (graph[x][y] != '*') {
                    return false;
                }
            }
        }
        return true;

    }

    /**
     * 分别向四个方向探测，计算*的长度是否一致；
     * @param graph
     * @param idx_x
     * @param idx_y
     * @return
     */
    public static boolean countStep(char[][] graph, int idx_x, int idx_y) {
        int count1 = 0;
        int x = idx_x - 1; int y = idx_y + 0;
        while (x >= 0) {
            if (graph[x][y] == '*') {
                if (y + 1 < graph[0].length) {
                    if (graph[x][y + 1] == '*') return false;
                }
                if (y - 1 >= 0) {
                    if (graph[x][y - 1] == '*') return false;
                }
                count1++;
                x--;
            }else {
                break;
            }
        }
        x = idx_x + 1; y = idx_y;
        int count2 = 0;
        while (x < graph.length) {
            if (graph[x][y] == '*') {
                if (y + 1 < graph[0].length) {
                    if (graph[x][y + 1] == '*') return false;
                }
                if (y - 1 >= 0) {
                    if (graph[x][y - 1] == '*') return false;
                }
                count2++;
                x++;
            }else {
                break;
            }
        }
        if (count2 != count1) return false;
        x = idx_x; y = idx_y - 1;
        int count3 = 0;
        while (y >= 0) {
            if (graph[x][y] == '*') {
                if (x + 1 < graph.length) {
                    if (graph[x + 1][y] == '*') return false;
                }
                if (x - 1 >= 0) {
                    if (graph[x - 1][y] == '*') return false;
                }
                y--;
                count3++;
            }else {
                break;
            }
        }
        if (count3  != count2) return false;
        x = idx_x; y = idx_y + 1;
        int count4 = 0;
        while (y < graph[0].length) {
            if (graph[x][y] == '*') {
                if (x + 1 < graph.length) {
                    if (graph[x + 1][y] == '*') return false;
                }
                if (x - 1 >= 0) {
                    if (graph[x - 1][y] == '*') return false;
                }
                y++;
                count4++;
            }else {
                break;
            }
        }
        if (count4 != count3) return false;
        return true;
    }

}
