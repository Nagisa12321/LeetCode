package com.leetcode.interview.No8.No8;

import java.util.*;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/20 16:01
 * @version 1.0
 ************************************************/
public class Solution {
    public String[] permutation(String S) {
        int[] map = new int[52];
        var list = new ArrayList<String>();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLowerCase(S.charAt(i)))
                map[S.charAt(i) - 'a']++;
            else map[S.charAt(i) - 'A' + 26]++;
        }
        track(list, map, new StringBuilder(), S.length());
        return list.toArray(String[]::new);
    }

    public void track(List<String> list, int[] map, StringBuilder builder, int len) {
        if (builder.length() == len) {
            list.add(builder.toString());
            return;
        }

        for (int i = 0; i < 52; i++) {
            if (map[i] > 0) {
                if (i < 26)
                    builder.append((char) (i + 'a'));
                else
                    builder.append((char) (i + 'A' - 26));
                map[i]--;
                track(list, map, builder, len);
                map[i]++;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
