package com.leetcode.recursion.No1.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/16 15:17
 */
public class Solution {
    public void reverseString(char[] s) {
        swap(0, s.length - 1, s);
    }

    public void swap(int start, int end, char[] s) {
        if (start >= end) return;

        swap(start + 1, end - 1, s);
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
    }
}