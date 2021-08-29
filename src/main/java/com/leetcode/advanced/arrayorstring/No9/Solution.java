package com.leetcode.advanced.arrayorstring.No9;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/25 11:18
 */
public class Solution {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        // Stack<Integer> numStack = new Stack<>(); // 数字栈
        int[] numStack = new int[len];
        int num_idx = 0;
        // Stack<Character> charStack = new Stack<>(); // 符号栈
        int[] charStack = new int[len];
        int char_idx = 0;
        int num = 0;

        for (char ch : chs) {
            // 忽略空格
            if (ch == ' ') continue;
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // 数字栈进栈, 并初始化数字
                // numStack.push(num);
                numStack[num_idx++] = num;
                num = 0;

                // 是+,-计算至栈空后进栈
                if (ch == '+' || ch == '-') {
                    while (char_idx != 0) {
                        int operator = charStack[--char_idx];
                        int num2 = numStack[--num_idx];
                        int num1 = numStack[--num_idx];

                        // 计算结果
                        int result = calculate(num1, num2, operator);

                        // 结果压入栈中
                        // numStack.push(result);
                        numStack[num_idx++] = result;
                    }
                }
                // 是*,/计算至栈空或者非乘除后进栈
                else {
                    // while (!charStack.isEmpty() && (charStack.peek() == '*' || charStack.peek() == '/')) {
                    //     calculate(numStack, charStack);
                    // }
                    while (char_idx != 0 && (charStack[char_idx - 1] == '*' || charStack[char_idx - 1] == '/')) {
                        int operator = charStack[--char_idx];
                        int num2 = numStack[--num_idx];
                        int num1 = numStack[--num_idx];

                        // 计算结果
                        int result = calculate(num1, num2, operator);

                        // 结果压入栈中
                        // numStack.push(result);
                        numStack[num_idx++] = result;
                    }
                }
                // charStack.push(ch);
                charStack[char_idx++] = ch;

            } else {
                num *= 10;
                num += ch - '0';
            }
        }
        numStack[num_idx++] = num;

        // 清理符号栈直至栈空
        while (char_idx != 0) {
            int operator = charStack[--char_idx];
            int num2 = numStack[--num_idx];
            int num1 = numStack[--num_idx];

            // 计算结果
            int result = calculate(num1, num2, operator);

            // 结果压入栈中
            // numStack.push(result);
            numStack[num_idx++] = result;
        }

        // 返回数字栈的栈顶数字就是答案
        return numStack[num_idx - 1];
    }

    public int calculate(int num1, int num2, int operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }
}