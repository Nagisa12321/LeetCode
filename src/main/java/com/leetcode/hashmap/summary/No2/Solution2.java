package com.leetcode.hashmap.summary.No2;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 11:00
 */
public class Solution2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;

        for (int a : A)
            for (int b : B)
                map.put(-(a + b), map.getOrDefault(-(a + b), 0) + 1);

        for (int c : C)
            for (int d : D)
                if (map.containsKey(c + d))
                    num += map.get(c + d);

        return num;
    }
}