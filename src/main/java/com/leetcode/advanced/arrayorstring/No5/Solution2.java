package com.leetcode.advanced.arrayorstring.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/24 10:54
 */
public class Solution2 {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = countLife(i, j, board);
                if (board[i][j] == 1) {
                    if (count < 2) board[i][j] = -1;
                    else if (count > 3) board[i][j] = -1;
                } else {
                    if (count == 3) board[i][j] = 123;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int board_i_j = board[i][j];
                if (board_i_j == -1) board[i][j] = 0;
                else if (board_i_j == 123) board[i][j] = 1;
            }
        }
    }

    public int countLife(int i, int j, int[][] board) {
        int num = 0;
        if (i - 1 >= 0 && j - 1 >= 0 && Math.abs(board[i - 1][j - 1]) == 1) num++;
        if (i - 1 >= 0 && Math.abs(board[i - 1][j]) == 1) num++;
        if (i - 1 >= 0 && j + 1 != board[0].length && Math.abs(board[i - 1][j + 1]) == 1) num++;
        if (j - 1 >= 0 && Math.abs(board[i][j - 1]) == 1) num++;
        if (j + 1 != board[0].length && Math.abs(board[i][j + 1]) == 1) num++;
        if (i + 1 != board.length && j - 1 >= 0 && Math.abs(board[i + 1][j - 1]) == 1) num++;
        if (i + 1 != board.length && Math.abs(board[i + 1][j]) == 1) num++;
        if (i + 1 != board.length && j + 1 != board[0].length && Math.abs(board[i + 1][j + 1]) == 1) num++;
        return num;
    }
}