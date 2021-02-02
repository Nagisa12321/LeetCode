package com.leetcode.algorithm.No1232;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 14:52
 */
public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        // 检查在同一x的情况
        int x = coordinates[0][0];
        boolean isStraightLine = true;
        for (int i = 1; i < coordinates.length; i++) {
            if (coordinates[i][0] != x) {
                isStraightLine = false;
                break;
            }
        }
        if (isStraightLine) return true;

        int lastX = coordinates[1][0];
        int lastY = coordinates[1][1];
        double K = (double) (coordinates[1][1] - coordinates[0][1])
                / (coordinates[1][0] - coordinates[0][0]);

        for (int i = 2; i < coordinates.length; i++) {
            double thisK = (double) (coordinates[i][1] - coordinates[i - 1][1])
                    / (coordinates[i][0] - coordinates[i - 1][0]);
            if (thisK != K) return false;
        }

        return true;
    }
}