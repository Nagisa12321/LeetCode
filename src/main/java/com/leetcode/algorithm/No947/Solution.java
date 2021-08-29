package com.leetcode.algorithm.No947;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/16 13:25
 */
public class Solution {
    public int removeStones(int[][] stones) {
        int len = stones.length;
        // 集合个数
        int count = len;
        // 集合id
        int[] id = new int[len];
        // 赋初始值
        for (int i = 0; i < len; i++) {
            id[i] = i;
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int findI = find(i, id);
                    int findJ = find(j, id);
                    if (findI != findJ) {
                        id[findI] = findJ;
                        count--;
                    }
                }
            }
        }

        return len - count;
    }

    public int find(int p, int[] id) {
        while (p != id[p]) p = id[p];
        return p;
    }
}