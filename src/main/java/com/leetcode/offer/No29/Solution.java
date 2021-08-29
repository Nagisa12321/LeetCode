package com.leetcode.offer.No29;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/18 11:14
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int[] res = new int[matrix.length * matrix[0].length]; // 结果
        int[][] help = new int[matrix.length][matrix[0].length]; // 辅助矩阵
        int idx = 0; // 结果的下标
        int direction = 1; // 移动方向
        int x = 0, y = 0; // 目前的坐标

        help[0][0] = 1;
        res[idx++] = matrix[0][0];
        p:
        while (true) {
            switch (direction) {
                case 1:
                    if (y == matrix[0].length - 1) {
                        if (x == matrix.length - 1) break p;
                        direction = 2;
                    } else if (help[x][y + 1] == 1) {
                        if (help[x + 1][y] == 1) break p;
                        direction = 2;
                    } else {
                        y++;
                        help[x][y] = 1;
                        res[idx++] = matrix[x][y];
                    }
                    break;
                case 4:
                    if (help[x - 1][y] == 1) {
                        if (help[x][y + 1] == 1) break p;
                        direction = 1;
                    } else {
                        x--;
                        help[x][y] = 1;
                        res[idx++] = matrix[x][y];
                    }
                    break;
                case 2:
                    if (x == matrix.length - 1) {
                        if (y == 0) break p;
                        direction = 3;
                    } else if (help[x + 1][y] == 1) {
                        if (help[x][y - 1] == 1) break p;
                        direction = 3;
                    } else {
                        x++;
                        help[x][y] = 1;
                        res[idx++] = matrix[x][y];
                    }
                    break;
                case 3:
                    if (y == 0) {
                        if (x == 0) break p;
                        direction = 4;
                    } else if (help[x][y - 1] == 1) {
                        if (help[x - 1][y] == 1) break p;
                        direction = 4;
                    } else {
                        y--;
                        help[x][y] = 1;
                        res[idx++] = matrix[x][y];
                    }
                    break;
            }
        }
        return res;
    }

}