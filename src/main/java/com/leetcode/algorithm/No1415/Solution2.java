package com.leetcode.algorithm.No1415;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/22 21:00
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        var map = new HashMap<String, Integer>();
        int max = 0;
        for (String word : words) {
            int chain = 1;
            int len = word.length();
            for (String key : map.keySet()) {
                if (map.get(key) == len - 1 && isPredecessor(key, word))
                    chain = Math.max(chain, map.get(key) + 1);
            }
            map.put(word, word.length());
            max = Math.max(max, chain);
        }
        return max - words[0].length() + 1;
    }

    private boolean isPredecessor(String a, String b) {
        int i = 0, j = 0;
        int m = a.length(), n = b.length();
        if ((m + 1) != n) return false;
        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == m;
    }
}
