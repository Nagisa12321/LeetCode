package com.leetcode.algorithm.No79;

import java.util.HashSet;

/************************************************
 * //³¬Ê±
 * @author jtchen
 * @date 2020/12/18 23:07
 * @version 1.0
 ************************************************/
public class Solution {

    private boolean have = false;

    public boolean exist(char[][] board, String word) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    set.add(i * 10 + j);
                    track(board, word, i, j, 0, set);
                    set.remove(i * 10 + j);
                }
            }
        }
        return have;
    }

    public void track(char[][] board, String word, int i, int j, int idx, HashSet<Integer> set) {
        if (idx == word.length() - 1) {
            have = true;
        } else {
            if (i < board.length - 1) {
                if (!set.contains((i + 1) * 10 + j)) {
                    if (board[i + 1][j] == word.charAt(idx + 1)) {
                        set.add((i + 1) * 10 + j);
                        track(board, word, i + 1, j, idx + 1, set);
                        set.remove((i + 1) * 10 + j);
                    }
                }
            }
            if (i > 0) {
                if (!set.contains((i - 1) * 10 + j)) {
                    if (board[i - 1][j] == word.charAt(idx + 1)) {
                        set.add((i - 1) * 10 + j);
                        track(board, word, i - 1, j, idx + 1, set);
                        set.remove((i - 1) * 10 + j);
                    }
                }
            }
            if (j < board[0].length - 1) {
                if (!set.contains(i * 10 + j + 1)) {
                    if (board[i][j + 1] == word.charAt(idx + 1)) {
                        set.add(i * 10 + j + 1);
                        track(board, word, i, j + 1, idx + 1, set);
                        set.remove(i * 10 + j + 1);
                    }
                }
            }
            if (j > 0) {
                if (!set.contains(i * 10 + j - 1)) {
                    if (board[i][j - 1] == word.charAt(idx + 1)) {
                        set.add(i * 10 + j - 1);
                        track(board, word, i, j - 1, idx + 1, set);
                        set.remove(i * 10 + j - 1);
                    }
                }
            }
        }
    }
}
