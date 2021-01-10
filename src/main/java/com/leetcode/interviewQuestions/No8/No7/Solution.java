package com.leetcode.interviewQuestions.No8.No7;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/20 18:17
 * @version 1.0
 ************************************************/
public class Solution {
    private int idx = 0;

    public String[] permutation(String S) {
        int len = 1;
        for (int i = S.length(); i >= 1; i--) len *= i;
        String[] res = new String[len];
        int[] map = new int[52];
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLowerCase(S.charAt(i)))
                map[S.charAt(i) - 'a']++;
            else map[S.charAt(i) - 'A' + 26]++;
        }
        track(res, new StringBuilder(), S.length(), map);
        return res;
    }

    public void track(String[] res, StringBuilder builder, int len, int[] map) {
        if (builder.length() == len) {
            res[idx++] = builder.toString();
            return;
        }
        for (int i = 0; i < 52; i++) {
            if (map[i] > 0) {
                if (i < 26)
                    builder.append((char) (i + 'a'));
                else
                    builder.append((char) (i + 'A' - 26));
                map[i]--;
                track(res, builder, len, map);
                map[i]++;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}