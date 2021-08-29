package com.leetcode.algorithm.No389;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/18 15:37
 * @version 1.0
 ************************************************/
public class Solution2 {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (a[t.charAt(i) - 'a'] == 0) return t.charAt(i);
            else a[t.charAt(i) - 'a']--;
        }
        return 0;
    }
}