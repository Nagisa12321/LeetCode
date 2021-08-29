package com.leetcode.offer.No58.reverseleftwords;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
