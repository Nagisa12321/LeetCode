package com.leetcode.intermediate.No5.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/29 10:03
 */
public class Solution2 {
    /*
     * 用row/col指针从左下角开始运动
     * 因为左下角开始的特点是向上减少，向右增加因此可行
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1, col = 0;
        while (col != matrix[0].length && row >= 0) {
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col]) col++;
            else row--;
        }
        return false;
    }
}