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
        // Stack<Integer> numStack = new Stack<>(); // ����ջ
        int[] numStack = new int[len];
        int num_idx = 0;
        // Stack<Character> charStack = new Stack<>(); // ����ջ
        int[] charStack = new int[len];
        int char_idx = 0;
        int num = 0;

        for (char ch : chs) {
            // ���Կո�
            if (ch == ' ') continue;
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // ����ջ��ջ, ����ʼ������
                // numStack.push(num);
                numStack[num_idx++] = num;
                num = 0;

                // ��+,-������ջ�պ��ջ
                if (ch == '+' || ch == '-') {
                    while (char_idx != 0) {
                        int operator = charStack[--char_idx];
                        int num2 = numStack[--num_idx];
                        int num1 = numStack[--num_idx];

                        // ������
                        int result = calculate(num1, num2, operator);

                        // ���ѹ��ջ��
                        // numStack.push(result);
                        numStack[num_idx++] = result;
                    }
                }
                // ��*,/������ջ�ջ��߷ǳ˳����ջ
                else {
                    // while (!charStack.isEmpty() && (charStack.peek() == '*' || charStack.peek() == '/')) {
                    //     calculate(numStack, charStack);
                    // }
                    while (char_idx != 0 && (charStack[char_idx - 1] == '*' || charStack[char_idx - 1] == '/')) {
                        int operator = charStack[--char_idx];
                        int num2 = numStack[--num_idx];
                        int num1 = numStack[--num_idx];

                        // ������
                        int result = calculate(num1, num2, operator);

                        // ���ѹ��ջ��
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

        // �������ջֱ��ջ��
        while (char_idx != 0) {
            int operator = charStack[--char_idx];
            int num2 = numStack[--num_idx];
            int num1 = numStack[--num_idx];

            // ������
            int result = calculate(num1, num2, operator);

            // ���ѹ��ջ��
            // numStack.push(result);
            numStack[num_idx++] = result;
        }

        // ��������ջ��ջ�����־��Ǵ�
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