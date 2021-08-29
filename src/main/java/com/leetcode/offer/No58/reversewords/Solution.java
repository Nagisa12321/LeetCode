package com.leetcode.offer.No58.reversewords;

import java.util.ArrayList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 11:12
 */
public class Solution {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        boolean isWriting = false;
        for (char ch : chs) {
            if (ch == ' ') {
                if (isWriting) {
                    list.add(builder.toString());
                    builder = new StringBuilder();
                    isWriting = false;
                }
            } else {
                isWriting = true;
                builder.append(ch);
            }
        }
        if (isWriting) list.add(builder.toString());

        builder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append(list.get(i));
            if (i != 0) builder.append(' ');
        }

        return builder.toString();
    }
}