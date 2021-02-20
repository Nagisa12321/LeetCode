package com.leetcode.offer.No31;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/18 13:26
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int push_idx = 0, pop_idx = 0;

        while (push_idx != len) {
            stack.push(pushed[push_idx++]);

            while (!stack.isEmpty() && stack.peek() == popped[pop_idx]) {
                stack.pop();
                pop_idx++;
            }
        }

        return pop_idx == len;
    }
}