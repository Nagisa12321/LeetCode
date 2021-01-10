package com.leetcode.algorithm.No17;

import java.util.LinkedList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/17 12:09
 * @version 1.0
 ************************************************/
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits.length() == 0) return list;
        StringBuilder builder = new StringBuilder();
        track(list, digits, 0, builder);
        return list;
    }

    public void track(List<String> list, String digits, int idx, StringBuilder builder) {
        if (idx == digits.length()) {
            list.add(builder.toString());
            return;
        }

        if (digits.charAt(idx) == '2') {
            builder.append('a');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('b');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('c');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (digits.charAt(idx) == '3') {
            builder.append('d');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('e');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('f');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (digits.charAt(idx) == '4') {
            builder.append('g');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('h');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('i');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (digits.charAt(idx) == '5') {
            builder.append('j');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('k');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('l');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (digits.charAt(idx) == '6') {
            builder.append('m');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('n');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('o');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (digits.charAt(idx) == '7') {
            builder.append('p');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('q');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('r');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('s');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (digits.charAt(idx) == '8') {
            builder.append('t');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('u');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('v');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (digits.charAt(idx) == '9') {
            builder.append('w');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('x');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('y');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('z');
            track(list, digits, idx + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
