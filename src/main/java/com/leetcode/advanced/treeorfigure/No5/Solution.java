package com.leetcode.advanced.treeorfigure.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/26 11:17
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int[] id = new int[len];
        for (int i = 0; i < len; i++)
            id[i] = i;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    int tmp = i;
                    while (tmp != id[tmp] && id[tmp] < j)
                        tmp = id[tmp];
                    if (tmp == id[tmp]) id[tmp] = j;
                    else {
                        int parent = id[tmp];
                        if (j == parent) continue;
                        id[tmp] = j;
                        id[j] = parent;
                    }
                }
            }
        }

        int num = 0;
        // 统计有多少根节点
        int[] map = new int[len];
        for (int i = 0; i < len; i++) {
            // 找寻根节点
            int tmp = i;
            while (tmp != id[tmp]) tmp = id[tmp];
            map[tmp]++;
        }

        for (int i = 0; i < len; i++) {
            if (map[i] != 0)
                num++;
        }

        return num;
    }
}