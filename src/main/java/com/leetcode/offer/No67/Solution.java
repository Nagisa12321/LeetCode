package com.leetcode.offer.No67;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/9 10:32
 */
public class Solution {
    public int strToInt(String str) {
        char[] chs = str.toCharArray();

        long num = 0;
        int state = 0; // ×´Ì¬»ú
        boolean positive = true;
        for (char ch : chs) {
            switch (state) {
                case 0:
                    if (ch == ' ') break;
                    else if (ch >= '0' && ch <= '9') {
                        state = 1;
                        num = ch - '0';
                        break;
                    } else if (ch == '+' || ch == '-') {
                        state = 2;
                        positive = ch == '+';
                        break;
                    } else return 0;
                case 1:
                    if (ch >= '0' && ch <= '9') {
                        num = positive ? num * 10 + ch - '0' : num * 10 - ch + '0';
                        if (positive && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                        else if (!positive && num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

                        break;
                    } else return (int) num;
                case 2:
                    if (ch >= '0' && ch <= '9') {
                        state = 1;
                        num = positive ? ch - '0' : '0' - ch;
                        break;
                    } else return 0;
            }
        }
        return (int) num;
    }
}