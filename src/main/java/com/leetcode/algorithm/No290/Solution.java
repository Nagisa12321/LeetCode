package com.leetcode.algorithm.No290;

import java.util.HashMap;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/16 11:03
 * @version 1.0
 ************************************************/
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        var map = new HashMap<Character, String>();
        String[] str = s.split(" ");
        if (str.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (map.containsValue(str[i])) return false;
                else map.put(pattern.charAt(i), str[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(str[i]))
                    return false;
            }
        }
        return true;
    }
}
