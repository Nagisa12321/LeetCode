package com.leetcode.algorithm.No424;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 22:16
 */
public  class Solution {
    public int characterReplacement(String s, int k) {
        if ("".equals(s)) return 0;
        char[] chs = s.toCharArray();
        int left = 0, right = 0;
        int[] map = new int[26];
        int len = chs.length;
        map[chs[0] - 'A']++;
        int size = 1;
        int max = 0;

        while (right <= len - 1) {
            while (right != len - 1 && isGoodMap(map, size, k)) {
                map[chs[++right] - 'A']++;
                size++;
            }
            if (isGoodMap(map, size, k))
                max = Math.max(max, size);
            else max = Math.max(max, size - 1);
            map[chs[left] - 'A']--;
            left++;
            right++;
            if (right == len) break;
            map[chs[right] - 'A']++;
        }

        return max;
    }

    public boolean isGoodMap(int[] map, int size, int k) {
        for (int i = 0; i < 26; i++)
            if (map[i] >= size - k) return true;
        return false;
    }
}