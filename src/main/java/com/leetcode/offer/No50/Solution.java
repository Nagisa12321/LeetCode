package com.leetcode.offer.No50;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/16 15:36
 */
public class Solution {
    public char firstUniqChar(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;

        int[] wordsMap = new int[26];
        int[] idxMap = new int[26];

        // ≥ı ºªØidxmap
        // for (int i = 0; i < 26; i++) idxMap[i] = len;

        for (int i = 0; i < chs.length; i++) {
            if (wordsMap[chs[i] - 'a']++ == 0)
                idxMap[chs[i] - 'a'] = i;
        }

        char res = ' ';
        int min = len;
        for (int i = 0; i < 26; i++) {
            if (wordsMap[i] == 1) {
                if (idxMap[i] < min) {
                    min = idxMap[i];
                    res = (char) (i + 'a');
                }
            }
        }

        return res;
    }
}