package com.leetcode.primary.No2.No4;

import java.util.Arrays;

/**
 * @排序后直接遍历
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chS = s.toCharArray(), chT = t.toCharArray();
        Arrays.sort(chS);
        Arrays.sort(chT);
        return Arrays.equals(chS,chT);
    }
}
