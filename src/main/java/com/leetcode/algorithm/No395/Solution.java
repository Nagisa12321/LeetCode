package com.leetcode.algorithm.No395;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 13:11
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        if (s.equals("")) return 0;

        char[] chs = s.toCharArray();
        int[] map = new int[26];

        for (char ch : chs) {
            map[ch - 'a']++;
        }

        int max = -1;
        boolean goodStr = true;
        LinkedList<String> strs = new LinkedList<>();
        strs.add(s);
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0 && map[i] < k) {
                goodStr = false;
                int size = strs.size();
                for (int j = 0; j < size; j++) {
                    String tmp = strs.removeFirst();
                    String[] split = tmp.split(String.valueOf((char) (i + 'a')));
                    for (String s1 : split) {
                        strs.addLast(s1);
                    }
                }
            }
        }
        for (String str : strs) {
            max = Integer.max(max, longestSubstring(str, k));
        }

        return goodStr ? chs.length : max;
    }
}