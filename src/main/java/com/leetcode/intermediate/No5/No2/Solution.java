package com.leetcode.intermediate.No5.No2;

import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/26 9:17
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (var entry : map.entrySet())
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = Objects.requireNonNull(pq.poll())[1];
        return res;
    }
}
