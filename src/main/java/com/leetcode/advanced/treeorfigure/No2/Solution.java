package com.leetcode.advanced.treeorfigure.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/25 13:25
 */
public class Solution {
    public void solve(char[][] board) {
        int len_i = board.length;
        int len_j = board[0].length;
        for (int i = 0; i < len_i; i++) {
            dfs(board, i, 0);
            dfs(board, i, len_j - 1);
        }
        for (int i = 0; i < len_j; i++) {
            dfs(board, 0, i);
            dfs(board, len_i - 1, i);
        }

        for (int i = 0; i < len_i; i++)
            for (int j = 0; j < len_j; j++) {
                char ch = board[i][j];

                if (ch == 'O') board[i][j] = 'X';
                else if (ch == '$') board[i][j] = 'O';
            }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        else if (board[x][y] == 'X' || board[x][y] == '$') return;

        board[x][y] = '$';
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
    }
}