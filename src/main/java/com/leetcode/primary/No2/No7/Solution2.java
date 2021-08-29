package com.leetcode.primary.No2.No7;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/11/25 18:24
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return -1;
        int[][] bp = new int[needle.length()][256];
        bp[0][needle.charAt(0)] = 1;
        int x = 0;
        for (int i = 1; i < needle.length(); ++i) {
            for (int ch = 0; ch < 256; ++ch)
                if (ch == needle.charAt(i))
                    bp[i][ch] = i + 1;
                else bp[i][ch] = bp[x][ch];
            x = bp[x][needle.charAt(i)];
        }
        int j = 0;
        for (int i = 0; i < haystack.length(); ++i) {
            j = bp[j][haystack.charAt(i)];
            if(j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }
}
