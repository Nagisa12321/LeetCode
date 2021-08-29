package com.leetcode.offer.No38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/13 22:00
 */
public class Solution {
    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        traverse(list, s, new StringBuilder(), new int[s.length()]);

        return list.toArray(String[]::new);
    }

    public void traverse(Set<String> list, String s, StringBuilder builder, int[] map) {
        if (builder.length() == s.length()) {

            for (int val : map) {
                if (val != 1) return;
            }

            list.add(builder.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            builder.append(s.charAt(i));
            map[i]++;
            traverse(list, s, builder, map);
            map[i]--;
            builder.deleteCharAt(builder.length() - 1);

        }
    }
}