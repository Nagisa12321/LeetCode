package com.leetcode.primary.No1.No10;

/**
 * 分别判断每行、每列、每宫格有没有重复的数字
 * 用自建Map[]来判断
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        //用Map来映射
        int[] xMap = new int[9];
        int[] yMap = new int[9];
        //判断每行,每列
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.')
                    if (xMap[board[i][j] - 49]++ > 0) return false;
                if (board[j][i] != '.')
                    if (yMap[board[j][i] - 49]++ > 0) return false;
            }
            //初始化
            xMap = new int[9];
            yMap = new int[9];
        }
        //判断九宫格
        xMap = new int[9];
        for (int i = 0; i < 9; i += 3)
            for (int j = 0; j < 9; j += 3) {
                for (int k = 0; k < 3; ++k)
                    for (int l = 0; l < 3; ++l)
                        if (board[i + k][j + l] != '.')
                            if (xMap[board[i + k][j + l] - 49]++ > 0) return false;
                xMap = new int[9];
            }
        return true;
    }
}
