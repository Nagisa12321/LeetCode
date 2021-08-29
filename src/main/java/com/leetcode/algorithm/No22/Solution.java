package com.leetcode.algorithm.No22;

import java.util.LinkedList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/16 17:07
 * @version 1.0
 ************************************************/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        track(list, builder, n - 1, n, 2 * n);
        return list;
    }

    public void track(List<String> list,
                      StringBuilder builder, int left, int right, int length) {
        if (left == 0 && right == 0) {
            list.add(builder.toString());
            return;
        }
        if (left > 0) {
            builder.append("(");
            track(list, builder, left - 1, right, length);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right > left) {
            builder.append(")");
            track(list, builder, left, right - 1, length);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
