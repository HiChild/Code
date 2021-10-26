package com.soe.leecode.testday202109.day14;

/**
 * 79.找字母
 */
public class Exist2 {

    static char[][] test = {
        {'z','y','a'},
        {'o','o','k'},
        {'a','x','u'}
    };
    boolean find = false;


    public static void main(String[] args) {
        Exist2 exist = new Exist2();
        System.out.println(exist.exist(test, "zooku"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                backtracking(i , j, board, visited, 0, word);
            }
        }
        return this.find;
    }

    private void backtracking(int i, int j, char[][] board, boolean[][] visited, int pos, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] ) {
            return;
        }
        if (board[i][j] != word.charAt(pos) || find) return;
        if (pos == word.length() - 1) {
            this.find = true;
            return;
        }
        visited[i][j] = true;
        backtracking(i - 1, j, board, visited, pos + 1, word);
        backtracking(i + 1, j, board, visited, pos + 1, word);
        backtracking(i, j - 1, board, visited, pos + 1, word);
        backtracking(i, j + 1, board, visited, pos + 1, word);
        visited[i][j] = false;
    }

}
