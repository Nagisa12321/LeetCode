package com.leetcode.algorithm.No392;

/************************************************
 * @description 直接扫描t，如果t有和s相同元素则s前进一格
 *              会后判断s是否走完即可
 * @author jtchen
 * @date 2020/12/4 11:00
 * @version 1.0
 ************************************************/
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int a = 0, b = 0;
        while (b != t.length())
            if (a == s.length()) return true;
            else if (s.charAt(a) == t.charAt(b++)) a++;
        return a == s.length();
    }
}
