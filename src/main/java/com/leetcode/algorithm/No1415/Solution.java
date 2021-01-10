package com.leetcode.algorithm.No1415;

import java.util.ArrayList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/20 23:08
 * @version 1.0
 ************************************************/
public class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        track(list, n, new StringBuilder());
        if (k > list.size()) return "";
        else return list.get(k - 1);
    }

    public void track(List<String> list, int n, StringBuilder builder) {
        if (builder.length() == n) {
            list.add(builder.toString());
            return;
        }
        if (builder.length() == 0) {
            builder.append('a');
            track(list, n, builder);
            builder.deleteCharAt(0);
            builder.append('b');
            track(list, n, builder);
            builder.deleteCharAt(0);
            builder.append('c');
            track(list, n, builder);
            builder.deleteCharAt(0);
        } else if (builder.charAt(builder.length() - 1) == 'a') {
            builder.append('b');
            track(list, n, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('c');
            track(list, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else if (builder.charAt(builder.length() - 1) == 'b') {
            builder.append('a');
            track(list, n, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('c');
            track(list, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        } else {
            builder.append('a');
            track(list, n, builder);
            builder.deleteCharAt(builder.length() - 1);
            builder.append('b');
            track(list, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}