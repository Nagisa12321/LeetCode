package com.leetcode.algorithm.No79;

import java.util.HashSet;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/18 23:56
 * @version 1.0
 ************************************************/
public class Solution2 {
    public boolean exist(char[][] board, String word) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int idx) {

        if (idx == word.length()) return true;

        if (i == -1 || j == -1 || i == board.length || j == board[0].length) return false;

        if (board[i][j] != word.charAt(idx)) return false;


        char t = board[i][j];
        board[i][j] = '0';

        boolean res = dfs(board, word, i + 1, j, idx + 1)
                || dfs(board, word, i - 1, j, idx + 1)
                || dfs(board, word, i, j + 1, idx + 1)
                || dfs(board, word, i, j - 1, idx + 1);

        board[i][j] = t;

        return res;

    }
}
