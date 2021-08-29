package com.leetcode.primary.No2.No3;

/**
 * @自建映射法 因为只有26个小写字母
 */
public class Solution {
    public int firstUniqChar(String s) {
        //建立映射
        int[] map = new int[26];
        //记录出现次数
        for (int i = 0; i < s.length(); ++i)
            map[s.charAt(i) - 'a']++;
        //返回第一个出现一次的字母下标
        for (int i = 0; i < s.length(); ++i)
            if (map[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }
}
