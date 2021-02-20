package com.leetcode.algorithm.No1208;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/20 21:06
 */
public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] chs_s = s.toCharArray();
        char[] chs_t = t.toCharArray();

        int len = chs_s.length;

        int[] costs = new int[len];
        for (int i = 0; i < len; i++) {
            costs[i] = Math.abs(chs_s[i] - chs_t[i]);
        }

        int max = 0;
        int left = 0, right = 0;
        int cost = costs[0];

        while (true) {
            while (right != len - 1 && cost <= maxCost) {
                right++;
                cost += costs[right];
            }

            if (cost > maxCost) max = Math.max(max, right - left);
            else max = Math.max(max, right - left + 1);

            cost -= costs[left];
            left++;
            right++;
            if (right == len) break;
            cost += costs[right];
        }

        return max;
    }
}