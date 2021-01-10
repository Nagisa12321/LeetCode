package com.leetcode.algorithm.No389;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/18 15:48
 * @version 1.0
 ************************************************/
public class Solution3 {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }
        a[t.charAt(t.length() - 1) - 'a']--;
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) return (char) (i + 'a');
        }
        return 0;
    }
}