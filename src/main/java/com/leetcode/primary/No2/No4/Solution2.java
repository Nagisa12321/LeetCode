package com.leetcode.primary.No2.No4;

/**
 * @分别入两个map， 在判断是否两个表的元素都相同
 */
public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] map1 = new int[26], map2 = new int[26];
        for (int i = 0; i < n; ++i) {
            map1[s.charAt(i) - 'a']++;
            map2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; ++i)
            if (map1[s.charAt(i) - 'a'] != map2[s.charAt(i) - 'a']) return false;
        return true;
    }
}
