package com.leetcode.recursion.No3.No1;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 12:43
 */
public class Solution2 {
    public int fib(int n) {
        return Memoization(n, new HashMap<Integer, Integer>());
    }

    public int Memoization(int n, HashMap<Integer, Integer> map) {
        if (n == 0 || n == 1) return n;
        if (map.containsKey(n)) return map.get(n);

        int result = Memoization(n - 1, map) + Memoization(n - 2, map);
        map.put(n, result);
        return result;
    }
}