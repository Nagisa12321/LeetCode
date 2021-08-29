package com.leetcode.intermediate.No1.No2;

import java.util.Arrays;

/**
 * �õ�һ���������
 * �õ�һ���������
 *
 * @author jtchen
 * @version 1.0
 * @date 2021/1/9 15:54
 */
public class Solution2 {
    public void setZeroes(int[][] matrix) {
        boolean l = false;

        for (int[] ints : matrix)
            if (ints[0] == 0) {
                l = true;
                break;
            }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                matrix[0][0] = 0;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {

                    // ���ڵ��С��ж�Ҫ��Ϊ0
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // ������һ�п�����Щ��Ҫ��0��������һ�п�����Щ��Ҫ��0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (matrix[0][0] == 0) {
            Arrays.fill(matrix[0], 0);
        }
        if (l) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
