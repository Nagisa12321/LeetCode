package com.leetcode.intermediate.No8.No3;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/1 10:28
 */
public class Solution {
    public int titleToNumber(String s) {
        // 看作是'26'进制
        int sum = 0;
        char[] chs = s.toCharArray();

        for (char ch : chs) {
            sum = 26 * sum + ch - 'A' + 1;
        }

        return sum;
    }
}