package com.leetcode.hashmap.No3.No1;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/5 10:59
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        if (chs.length != cht.length) return false;
        return getSecretCode(chs) == getSecretCode(cht);
    }

    public int getSecretCode(char[] chs) {
        var map = new HashMap<Character, Integer>();

        int codeBuilder = 1, code = 0;
        for (char ch : chs) {
            if (map.containsKey(ch)) {
                code = 10 * code + map.get(ch);
            } else {
                code = 10 * code + codeBuilder;
                map.put(ch, codeBuilder++);
            }
        }

        return code;
    }
}