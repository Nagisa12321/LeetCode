package com.leetcode.algorithm.No387;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/23 13:03
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[ch[i] - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (map[ch[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
