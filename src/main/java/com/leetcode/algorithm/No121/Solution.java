package com.leetcode.algorithm.No121;

import java.util.Stack;

/**
 * 单调栈实现
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        Stack<Integer> theStack = new Stack<>();
        for (int i = 0; i != prices.length; ++i) {
            while (!theStack.isEmpty() && theStack.peek() > prices[i])
                theStack.pop();
            theStack.push(prices[i]);
            max = Math.max(max, theStack.peek() - theStack.get(0));
        }
        return max;
    }
}
