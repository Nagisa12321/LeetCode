package com.leetcode.recursion.No3.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 12:32
 */
public class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;

        return fib(n - 1) + fib(n - 2);
    }
}