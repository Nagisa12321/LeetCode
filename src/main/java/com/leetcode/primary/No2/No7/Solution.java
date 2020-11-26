package com.leetcode.primary.No2.No7;

/**
 * @普通双指针 超出时间限制
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals(haystack)) return 0;
        else if (needle.length() > haystack.length()) return -1;
        int a = 0, b = 0, index;
        while (a != haystack.length() - needle.length() + 1) {
            if (haystack.charAt(a) != needle.charAt(b)) ++a;
            else {
                int tmp = a;
                index = a;
                boolean isIndex = true;
                while (b != needle.length()) {
                    if (a == haystack.length() || (haystack.charAt(a) != needle.charAt(b))) {
                        isIndex = false;
                        b = 0;
                        break;
                    }
                    ++a;
                    ++b;
                }
                if (isIndex) return index;
                a = tmp + 1;
            }
        }
        return -1;
    }
}