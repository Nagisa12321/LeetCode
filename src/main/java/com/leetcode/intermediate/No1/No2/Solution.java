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
                // 先存列在存行, 待会直接行、列
                if (matrix[i][j] == 0) {
                    stack.push(j);
                    stack.push(i);
                }
            }
        }
        // 栈空为止
        while (!stack.isEmpty()) {
            int i = stack.pop();
            int j = stack.pop();

            // 行变0
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[i][k] = 0;
            }

            // 列变0
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][j] = 0;
            }
        }
    }
}