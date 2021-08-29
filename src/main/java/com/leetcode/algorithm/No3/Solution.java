package com.leetcode.algorithm.No3;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 10:06
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        char[] ch = s.toCharArray();
        int left = 0, right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < ch.length) {
            while (right < ch.length && set.add(ch[right])) right++;

            //¼ÆËã³¤¶È
            if (right - left > max) max = right - left;
            if (right == ch.length) break;
            char tmp = ch[right];

            while (set.contains(tmp) && left < right)
                set.remove(ch[left++]);

            set.add(tmp);
            right++;
        }

        return max;
    }
}