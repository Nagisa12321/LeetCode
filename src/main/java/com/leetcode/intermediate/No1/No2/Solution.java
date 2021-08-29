package com.leetcode.intermediate.No1.No2;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/9 15:54
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        var stack = new Stack<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // �ȴ����ڴ���, ����ֱ���С���
                if (matrix[i][j] == 0) {
                    stack.push(j);
                    stack.push(i);
                }
            }
        }
        // ջ��Ϊֹ
        while (!stack.isEmpty()) {
            int i = stack.pop();
            int j = stack.pop();

            // �б�0
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[i][k] = 0;
            }

            // �б�0
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][j] = 0;
            }
        }
    }
}