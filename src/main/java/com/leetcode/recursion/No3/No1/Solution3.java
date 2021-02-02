package com.leetcode.recursion.No3.No1;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 12:48
 */
public class Solution3 {
    public int fib(int n) {
        return Memoization(n, new HashMap<Integer, Integer>());
    }

    public int Memoization(int n, HashMap<Integer, Integer> map) {
        if (n == 0 || n == 1) return n;
        if (map.containsKey(n)) return map.get(n);

        int a, b;
        if (map.containsKey(n - 1)) a = map.get(n - 1);
        else {
            a = Memoization(n - 1, map);
            map.put(n - 1, a);
        }
        if (map.containsKey(n - 2)) b = map.get(n - 2);
        else {
            b = Memoization(n - 2, map);
            map.put(n - 2, b);
        }

        return a + b;
    }
}