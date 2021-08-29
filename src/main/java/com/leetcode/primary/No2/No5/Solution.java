package com.leetcode.primary.No2.No5;

/**
 * @筛选后判断
 */
public class Solution {
    private boolean isNum(char ch) {
        return (ch >= 48 && ch <= 57);
    }

    private boolean isChar(char ch) {
        return ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122));
    }

    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i)
            if (isNum(s.charAt(i))) builder.append(s.charAt(i));
            else if (isChar(s.charAt(i))) builder.append((char)(s.charAt(i) | 0x20));
        String newStr = builder.toString();
        for (int i = 0; i < newStr.length() / 2; ++i)
            if (newStr.charAt(i) != newStr.charAt(newStr.length() - 1 - i)) return false;
        return true;
    }
}