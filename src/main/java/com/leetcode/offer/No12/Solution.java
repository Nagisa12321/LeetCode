package com.leetcode.offer.No12;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/11 10:05
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chs = word.toCharArray();

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (chs[0] == board[i][j] && dfs(board, i, j, chs, 0)) return true;
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, char[] chs, int idx) {
        if (idx == chs.length) return true;

            // ·¶Î§Ô½½ç
        else if (x < 0 || x == board.length || y < 0 || y == board[0].length)
            return false;


        else if (board[x][y] != chs[idx]) return false;

        char tmp = board[x][y];
        board[x][y] = '$';

        boolean res = dfs(board, x - 1, y, chs, idx + 1) ||
                dfs(board, x + 1, y, chs, idx + 1) ||
                dfs(board, x, y - 1, chs, idx + 1) ||
                dfs(board, x, y + 1, chs, idx + 1);

        board[x][y] = tmp;

        return res;
    }
}