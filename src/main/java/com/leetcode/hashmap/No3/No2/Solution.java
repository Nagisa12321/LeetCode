package com.leetcode.hashmap.No3.No2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/5 11:10
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        var map = new HashMap<String, Integer>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = list1.length + list2.length;
        var ans = new ArrayList<String>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int idx = map.get(list2[i]);
                if (idx + i < min) {
                    min = idx + i;
                    ans.clear();
                    ans.add(list2[i]);
                } else if (idx + i == min)
                    ans.add(list2[i]);

            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}