package com.leetcode.algorithm.No59;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/28 12:05
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int status = 0;// 0:right, 1:down, 2:left, 3:up
        int nowLen = 0;
        int x = 0, y = 0;
        int num = 1;
        int[][] res = new int[n][n];
        int size = n * n;
        for (int i = 0; i < size; i++) {
            switch (status) {
                case 0:
                    res[x][y++] = num++;
                    nowLen++;
                    if (nowLen == n) {
                        y--;
                        x++;
                        nowLen = 1;
                        status = (status + 1) % 4;
                    }
                    break;
                case 1:
                    res[x++][y] = num++;
                    nowLen++;
                    if (nowLen == n) {
                        x--;
                        y--;
                        nowLen = 1;
                        status = (status + 1) % 4;
                    }
                    break;
                case 2:
                    res[x][y--] = num++;
                    nowLen++;
                    if (nowLen == n) {
                        y++;
                        x--;
                        nowLen = 1;
                        status = (status + 1) % 4;
                    }
                    break;
                case 3:
                    res[x--][y] = num++;
                    nowLen++;
                    if (nowLen == n - 1) {
                        x++;
                        y++;
                        n -= 2;
                        nowLen = 0;
                        status = (status + 1) % 4;
                    }
                    break;
            }
        }
        return res;
    }
}