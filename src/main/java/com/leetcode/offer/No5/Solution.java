package com.leetcode.offer.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 11:24
 */
public class Solution {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chs = s.toCharArray();

        for (char ch : chs) {
            if (ch == ' ')
                builder.append("%20");
            else builder.append(ch);
        }

        return builder.toString();
    }
}