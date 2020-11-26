package com.leetcode.primary.No2.No3;

import java.util.HashMap;

/**
 * @HashMap
 */
public class Solution2 {
    public int firstUniqChar(String s) {
        var theMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i)
            if (theMap.containsKey(s.charAt(i))) theMap.put(s.charAt(i), theMap.get(s.charAt(i)) + 1);
            else theMap.put(s.charAt(i), 1);
        for (int i = 0; i < s.length(); ++i)
            if (theMap.get(s.charAt(i)) == 1) return i;
        return -1;
    }
}
