package com.leetcode.hashmap.summary.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 9:53
 */
public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] ch1 = jewels.toCharArray();
        char[] ch2 = stones.toCharArray();

        int[] map = new int[58];
        for (char c : ch1) map[c - 'A']++;

        int num = 0;
        for (char c : ch2) if (map[c - 'A'] != 0) num++;
        return num;
    }
}