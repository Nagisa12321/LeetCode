package com.leetcode.algorithm.No567;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/22 11:11
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] chs_s1 = s1.toCharArray();
        char[] chs_s2 = s2.toCharArray();
        if (chs_s1.length > chs_s2.length) return false;

        int len = chs_s1.length;
        int[] map_s1 = new int[26];
        int[] map_s2 = new int[26];

        // s1的map
        // 初始窗口的map
        for (int i = 0; i < len; i++) {
            map_s1[chs_s1[i] - 'a']++;
            map_s2[chs_s2[i] - 'a']++;
        }


        for (int i = 0; i <= chs_s2.length - len; i++) {
            if (i > 0) {
                map_s2[chs_s2[i - 1] - 'a']--;
                map_s2[chs_s2[i + len - 1] - 'a']++;
            }
            if (checkEqual(map_s1, map_s2)) return true;
        }
        return false;
    }

    public boolean checkEqual(int[] map_s1, int[] map_s2) {
        for (int i = 0; i < 26; i++) {
            if (map_s1[i] != map_s2[i]) return false;
        }
        return true;
    }
}