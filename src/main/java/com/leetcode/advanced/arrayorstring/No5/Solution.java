package com.leetcode.advanced.arrayorstring.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/24 10:54
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int[][] res = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // res[i][j] = board[i][j];
                int count = countLife(i, j, board);
                if (board[i][j] == 1) {
                    if (count < 2) res[i][j] = 0;
                    else if (count > 3) res[i][j] = 0;
                    else res[i][j] = 1;
                } else {
                    if (count == 3) res[i][j] = 1;
                    else res[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            System.arraycopy(res[i], 0, board[i], 0, board[0].length);
        }
    }

    public int countLife(int i, int j, int[][] board) {
        int num = 0;
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) num++;
        if (i - 1 >= 0 && board[i - 1][j] == 1) num++;
        if (i - 1 >= 0 && j + 1 != board[0].length && board[i - 1][j + 1] == 1) num++;
        if (j - 1 >= 0 && board[i][j - 1] == 1) num++;
        if (j + 1 != board[0].length && board[i][j + 1] == 1) num++;
        if (i + 1 != board.length && j - 1 >= 0 && board[i + 1][j - 1] == 1) num++;
        if (i + 1 != board.length && board[i + 1][j] == 1) num++;
        if (i + 1 != board.length && j + 1 != board[0].length && board[i + 1][j + 1] == 1) num++;
        return num;
    }
}