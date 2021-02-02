package com.leetcode.intermediate.No5.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/29 8:38
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    public boolean searchMatrix(int[][] matrix, int target, int x_lo, int x_hi, int y_lo, int y_hi) {
        if (x_lo > x_hi || y_lo > y_hi) return false;
        else if (x_lo == x_hi && y_lo == y_hi) return matrix[x_lo][y_lo] == target;
        else if (x_lo == x_hi) {
            int y_mid = y_lo + (y_hi - y_lo) / 2;
            if (matrix[x_lo][y_mid] == target) return true;

            boolean left = searchMatrix(matrix, target, x_lo, x_hi, y_lo, y_mid - 1);
            boolean right = searchMatrix(matrix, target, x_lo, x_hi, y_mid + 1, y_hi);
            return left || right;
        } else if (y_lo == y_hi) {
            int x_mid = x_lo + (x_hi - x_lo) / 2;
            if (matrix[x_mid][y_lo] == target) return true;

            boolean up = searchMatrix(matrix, target, x_lo, x_mid - 1, y_lo, y_hi);
            boolean down = searchMatrix(matrix, target, x_mid + 1, x_hi, y_lo, y_hi);
            return up || down;
        }

        int x_mid = x_lo + (x_hi - x_lo) / 2;
        int y_mid = y_lo + (y_hi - y_lo) / 2;

        if (matrix[x_mid][y_mid] == target) return true;
        boolean row = searchMatrix(matrix, target, x_mid, x_mid, y_lo, y_hi);
        boolean col = searchMatrix(matrix, target, x_lo, x_hi, y_mid, y_mid);
        boolean leftUp = searchMatrix(matrix, target, x_lo, x_mid - 1, y_lo, y_mid - 1);
        boolean rightUp = searchMatrix(matrix, target, x_mid + 1, x_hi, y_lo, y_mid - 1);
        boolean leftDown = searchMatrix(matrix, target, x_lo, x_mid - 1, y_mid + 1, y_hi);
        boolean rightDown = searchMatrix(matrix, target, x_mid + 1, x_hi, y_mid + 1, y_hi);
        return leftUp || rightUp || leftDown || rightDown || row || col;
    }
}