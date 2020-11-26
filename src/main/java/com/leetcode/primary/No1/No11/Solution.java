package com.leetcode.primary.No1.No11;

/**
 * @翻转后再翻转 先沿着左上——右下对角线翻转
 * 然后再翻转每一行
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int tmp,n = matrix.length;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                if (j > i) {
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 -j];
                matrix[i][n - 1 -j] = tmp;
            }
        }
    }
}
