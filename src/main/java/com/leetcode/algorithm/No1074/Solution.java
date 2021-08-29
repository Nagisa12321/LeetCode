package com.leetcode.algorithm.No1074;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int len_i = matrix.length;
        int len_j = matrix[0].length;
        int[][] help = new int[len_i][len_j];
        for (int i = 0; i < len_i; i++) {
            for (int j = 0; j < len_j; j++) {
                help[i][j] = (i == 0 ? i : help[i - 1][j]) + 
                            (j == 0 ? j : help[i][j - 1]) - 
                            (i == 0 || j == 0 ? 0 : help[i - 1][j - 1]) + 
                            matrix[i][j];
            }
        }
        int num = 0;
        // 朴素二维前缀和
        for (int i1 = 0; i1 < len_i; i1++) {
            for (int j1 = 0; j1 < len_j; j1++) {
                for (int i2 = i1; i2 < len_i; i2++) {
                    for (int j2 = j1; j2 < len_j; j2++) {
                        if (getSum(help, i1, j1, i2, j2) == target) 
                            num++;
                    }
                }
            }
        }
        return num;
    }

    private int getSum(int[][] help, int i1, int j1, int i2, int j2) {
        return help[i2][j2] - 
                (i1 == 0 ? 0 : help[i1 - 1][j2]) -
                (j1 == 0 ? 0 : help[i2][j1 - 1]) + 
                (i1 == 0 || j1 == 0 ? 0 : help[i1 - 1][j1 - 1]);
    }
}
