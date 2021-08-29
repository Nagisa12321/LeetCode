package com.leetcode.intermediate.No9.No2;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 11:18
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int b = stack.pop();
                    int a = stack.pop();

                    stack.push(a + b);
                    break;
                }
                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();

                    stack.push(a - b);
                    break;
                }
                case "*": {
                    int b = stack.pop();
                    int a = stack.pop();

                    stack.push(a * b);
                    break;
                }
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();

                    stack.push(a / b);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }
}