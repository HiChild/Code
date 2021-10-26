package com.soe.leecode.testday202109.day14;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * 79.找字母
 */
public class Exist {

    static char[][] test = {
        {'z','y','a'},
        {'o','o','k'},
        {'a','x','u'}
    };
    boolean find = false;


    public static void main(String[] args) {
        Exist exist = new Exist();
        System.out.println(exist.exist(test, "zooku"));
    }

    public boolean exist(char[][] board, String word) {
        if (word.equals("")) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                backtracking(i, j , board,word , visited, 0);
            }
        }
        return find;
    }

    private void backtracking(int i, int j, char[][] board, String word,  boolean[][] visited, int pos) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ) {
            return;
        }
        if (visited[i][j] || find || board[i][j] != word.charAt(pos)) {
            return;
        }
        if (pos == word.length() - 1) {
            this.find = true;
            return;
        }
        visited[i][j] = true; //修改当前状态
        //递归子节点
        backtracking(i + 1, j, board, word, visited, pos + 1);
        backtracking(i - 1, j, board, word, visited, pos + 1);
        backtracking(i, j + 1, board, word, visited, pos + 1);
        backtracking(i, j - 1, board, word, visited, pos + 1);
        visited[i][j] = false;
    }
}
