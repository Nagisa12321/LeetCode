package com.leetcode.offer.No20;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/8 10:29
 */
public class Solution {
    private int state = 1;

    public boolean isNumber(String s) {

        state = 1;
        char[] chs = s.toCharArray();

        int first = 0, last = chs.length - 1;
        // 去除前后空格
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') first = i + 1;
            else break;
        }

        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == ' ') last = i - 1;
            else break;
        }

        for (int i = first; i <= last; i++) {
            if (!stateChange(chs[i])) return false;
        }

        // 判断是否为最终态
        return state == 10 || state == 3 || state == 4 || state == 5 || state == 7;
    }

    public boolean stateChange(char ch) {
        switch (state) {
            case 1:
                if (ch == '+' || ch == '-') {
                    state = 2;
                    return true;
                } else if (ch >= '0' && ch <= '9') {
                    state = 3;
                    return true;
                } else if (ch == '.') {
                    state = 9;
                    return true;
                } else return false;
            case 2:
                if (ch >= '0' && ch <= '9') {
                    state = 3;
                    return true;
                } else if (ch == '.') {
                    state = 9;
                    return true;
                } else return false;
            case 3:
                if (ch >= '0' && ch <= '9') return true;
                else if (ch == '.') {
                    state = 4;
                    return true;
                } else if (ch == 'e' || ch == 'E') {
                    state = 6;
                    return true;
                } else return false;
            case 4:
                if (ch >= '0' && ch <= '9') {
                    state = 5;
                    return true;
                } else if (ch == 'e' || ch == 'E') {
                    state = 6;
                    return true;
                } else return false;
            case 5:
            case 10:
                if (ch >= '0' && ch <= '9') return true;
                else if (ch == 'e' || ch == 'E') {
                    state = 6;
                    return true;
                } else return false;
            case 6:
                if (ch >= '0' && ch <= '9') {
                    state = 7;
                    return true;
                } else if (ch == '-' || ch == '+') {
                    state = 8;
                    return true;
                }
            case 7:
                return ch >= '0' && ch <= '9';
            case 8:
                if (ch >= '0' && ch <= '9') {
                    state = 7;
                    return true;
                } else return false;
            case 9:
                if (ch >= '0' && ch <= '9') {
                    state = 10;
                    return true;
                }/* else if (ch == 'e' || ch == 'E') {
                    state = 6;
                    return true;
                } */ else return false;
        }
        return false;
    }
}