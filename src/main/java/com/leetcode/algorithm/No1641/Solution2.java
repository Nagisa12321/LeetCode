package com.leetcode.algorithm.No1641;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/8 11:31
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }
}
