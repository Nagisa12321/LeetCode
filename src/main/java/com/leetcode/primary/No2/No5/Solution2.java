package com.leetcode.primary.No2.No5;

/**
 * @一次遍历
 */
public class Solution2 {
    private boolean isNum(char ch) {
        return (ch >= 48 && ch <= 57);
    }

    private boolean isChar(char ch) {
        return ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122));
    }

    public boolean isPalindrome(String s) {
        int n = s.length(), left = 0, right = n - 1;
        while (left < right) {
            if (!isChar(s.charAt(left)) && !isNum(s.charAt(left))) ++left;
            else if (!isChar(s.charAt(right)) && !isNum(s.charAt(right))) --right;
            else {
                if (isNum(s.charAt(left)) && (s.charAt(left) != s.charAt(right))) return false;
                else if (isChar(s.charAt(left)) &&
                        (((char) (s.charAt(left) | 0x20)) != ((char) (s.charAt(right)| 0x20)))) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
