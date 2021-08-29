package com.leetcode.algorithm.No867;

/**
 * 暴力搜索法
 */
public class Solution {
    public int[][] transpose(int[][] A) {
        int x = A.length, y = A[0].length;
        int[][] newArray = new int[y][x];
        for (int i = 0; i < y; ++i) {
            for(int j = 0; j < x; ++j){
                newArray[i][j] = A[j][i];
            }
        }
        return newArray;
    }
}
