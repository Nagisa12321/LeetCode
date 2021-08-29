package com.leetcode.algorithm.No455;

import java.util.Arrays;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/25 18:44
 * @version 1.0
 ************************************************/
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIdx = 0, sIdx = 0;
        while (gIdx < g.length && sIdx < s.length) {
            if (g[gIdx] <= s[sIdx])
                gIdx++;
            sIdx++;
        }
        return gIdx;
    }
}