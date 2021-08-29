package com.leetcode.algorithm.No8;
public class Solution {
    final int INT_MAX = (int) (Math.pow(2, 31) - 1);
    final int INT_MIN = (int) (-Math.pow(2, 31));

    public int myAtoi(String s) {
        StringBuilder theBuilder = new StringBuilder();
        boolean hasNegative = false;
        boolean hasPositive = false;
        boolean hasNumberBefore = false;
        boolean isPositive = true;
//        boolean isBeginning = false; 是否考虑0？
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                if (!hasNegative && !hasPositive) {
                    hasNegative = true;
                    isPositive = false;
                    hasNumberBefore = true;
                    theBuilder.append(s.charAt(i));
                } else break;
            } else if (s.charAt(i) == '+') {
                if (!hasNegative && !hasPositive) {
                    hasPositive = true;
                    hasNumberBefore = true;
                } else break;
            } else if (s.charAt(i) == ' ') {
                if (hasNumberBefore)
                    break;
            } else if (s.charAt(i) >= 0x30 && s.charAt(i) <= 0x39) {
                hasNegative = true;
                hasNumberBefore = true;
                theBuilder.append(s.charAt(i));
            } else
                break;
        }
        try {
            if (!theBuilder.toString().equals("") && !theBuilder.toString().equals("-"))
                return Integer.parseInt(theBuilder.toString());
            else return 0;
        } catch (NumberFormatException e) {
            if (isPositive)
                return INT_MAX;
            else return INT_MIN;
        }
    }
}
