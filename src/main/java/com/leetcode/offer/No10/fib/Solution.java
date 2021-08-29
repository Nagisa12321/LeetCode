package com.leetcode.offer.No10.fib;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/9 11:00
 */
public class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int fib1;
        if (map.containsKey(n - 1)) fib1 = map.get(n - 1);
        else {
            fib1 = fib(n - 1);
            map.put(n - 1, fib1);
        }

        int fib2;
        if (map.containsKey(n - 2)) fib2 = map.get(n - 2);
        else {
            fib2 = fib(n - 2);
            map.put(n - 2, fib2);
        }

        return fib1 + fib2;
    }
}