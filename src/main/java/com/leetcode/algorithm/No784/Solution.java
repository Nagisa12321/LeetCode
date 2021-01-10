package com.leetcode.algorithm.No784;

import java.util.ArrayList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/20 22:34
 * @version 1.0
 ************************************************/
public class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        track(list, 0, new StringBuilder(), S);
        return list;
    }

    public void track(List<String> list, int idx, StringBuilder builder, String S) {
        if (builder.length() == S.length()) {
            list.add(builder.toString());
            return;
        }
        if (Character.isLowerCase(S.charAt(idx))) {
            builder.append((char) (S.charAt(idx) - 32));
            track(list, idx + 1, builder, S);
            builder.deleteCharAt(builder.length() - 1);
        } else if (Character.isUpperCase(S.charAt(idx))) {
            builder.append((char) (S.charAt(idx) + 32));
            track(list, idx + 1, builder, S);
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append(S.charAt(idx));
        track(list, idx + 1, builder, S);
        builder.deleteCharAt(builder.length() - 1);
    }
}
