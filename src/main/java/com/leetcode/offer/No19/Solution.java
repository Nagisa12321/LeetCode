package com.leetcode.offer.No19;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/17 11:12
 */
public class Solution {
    private boolean endofX = false;

    public boolean isMatch(String s, String p) {
        int[][] bp = buildBP(p);

        char[] chs = s.toCharArray();
        int states = 0;

        for (char ch : chs) {
            states = bp[states][ch];
            if (states == 0) return false;
        }

        return endofX ? (states == bp.length - 1 || states == bp.length - 2) : states == bp.length - 1;
    }

    public int[][] buildBP(String p) {
        char[] chs = p.toCharArray();

        endofX = chs[chs.length - 1] == '*';

        int states = 0;

        // 计算状态数
        for (char ch : chs) {
            if (ch != '*') states++;
        }

        int[][] bp = new int[states + 1][256];
        states = 0;
        int curstates = -1;
        int laststate = 0;

        // 构建bp数组
        // 如果是a-z: 判断curstate, bp[state++]['a' - 'z'] = state;
        // 如果是.: 判断curstate, bp[state][0] - bp[state][255] = state + 1, state++;
        /* 如果是*:
            >> 前一位为'a' - 'z':
                bp[state]['a' - 'z'] = state;
            >> 前一位为'.':
                bp[state][0] - bp[state][256] = state;

            state--;
            记录curstate；
         */
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '.') {
                for (int j = 0; j < 256; j++) {
                    if (curstates != -1) {
                        bp[curstates][j] = states + 1;
                    }
                    bp[laststate][j] = states + 1;
                }
                states++;
                laststate = states;
                curstates = -1;
            } else if (chs[i] == '*') {
                // 计算上一个state
                int jumpstate = 0;

                int tmp = i;
                while (tmp > 0 && chs[tmp] == '*') {
                    jumpstate++;
                    tmp -= 2;
                }
                laststate -= jumpstate;

                curstates = states;
                if (chs[i - 1] == '.') {
                    for (int j = 0; j < 256; j++) {
                        bp[states][j] = states;
                    }
                } else {
                    bp[states][chs[i - 1]] = states;
                }
            } else {

                if (i != 0 && chs[i - 1] == '*' && chs[i - 2] == chs[i]) {
                    states++;
                    if (i == chs.length - 1) endofX = true;
                    continue;
                }

                bp[laststate][chs[i]] = states + 1;
                if (curstates != -1)
                    bp[curstates][chs[i]] = states + 1;
                states++;
                laststate = states;
                curstates = -1;
            }
        }

        return bp;
    }
}