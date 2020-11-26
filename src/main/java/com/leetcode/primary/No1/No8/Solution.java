package com.leetcode.primary.No1.No8;

public class Solution {
    public int[] plusOne(int[] digits) {
        int CF = 1;//进位标志
        for (int i = digits.length - 1; i >= 0; --i) {
            int tmp = CF;
            CF = (digits[i] + CF) / 10;
            digits[i] = (digits[i] + tmp) % 10;
            if (CF == 0) break;
        }
        if (CF == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
