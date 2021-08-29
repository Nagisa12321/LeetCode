package com.leetcode.algorithm.No49;

import java.util.*;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/13 14:36
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] tmp = new int[26];
            for (int j = 0; j < str.length(); j++) {
                tmp[str.charAt(j) - 'a']++;
            }
            List<String> list;
            if (map.containsKey(Arrays.toString(tmp)))
                list = map.get(Arrays.toString(tmp));
            else list = new LinkedList<>();
            list.add(str);
            map.put(Arrays.toString(tmp), list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet())
            ret.add(entry.getValue());
        return ret;
    }
}
