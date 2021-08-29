package com.leetcode.algorithm.No1074;

public class Solution1 {
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
        for (int i1 = 0; i1 < len_i; i1++) {
            for (int i2 = i1; i2 < len_i; i2++) {
                // 滑动窗口. 
                int j1 = 0, j2 = 0;
                int tmp;
                while (j2 != len_j) {
                    tmp = getSum(help, i1, j1, i2, j2);
                    if (tmp == target) {
                        num++;
                        j2++;
                    } else if (tmp < target) {
                        j2++;
                    } else {
                        if (j1 == j2) {
                            j1++;
                            j2++;
                        } else {
                            j1++;
                        }
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

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[][] matrix = { { 1, -1 }, { -1, 1 } };
        int res = solution.numSubmatrixSumTarget(matrix, 0);
        System.out.println(res);
    }
}
