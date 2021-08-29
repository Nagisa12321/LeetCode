package com.leetcode.algorithm.No389;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/18 15:36
 * @version 1.0
 ************************************************/
public class Solution {
    public char findTheDifference(String s, String t) {
        int xor = 0;
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        for (int i = 0; i < s.length(); i++) xor ^= ch1[i];
        for (int i = 0; i < t.length(); i++) xor ^= ch2[i];
        return (char) xor;
    }
}