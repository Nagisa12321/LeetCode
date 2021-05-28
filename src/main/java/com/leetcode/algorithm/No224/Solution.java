package com.leetcode.algorithm.No224;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 15:44
 */
public class Solution {
	public int calculate(String s) {
		char[] chs = s.toCharArray();


		int[] chstack = new int[chs.length];
		int chs_idx = 0;
		int[] nums = new int[chs.length];
		int num_idx = 0;


		int num = 0;
		char last = 0;
		for (char ch : chs) {
			if (ch == ' ') continue;
			if (ch == '(')
				chstack[chs_idx++] = '(';
			else if (ch >= '0' && ch <= '9')
				num = num * 10 + ch - '0';
			else if (ch == ')') {
				if (last != ')') {
					nums[num_idx++] = num;
					num = 0;
				}
				while (chstack[chs_idx - 1] != '(') {

					int num2 = nums[--num_idx];
					int num1 = nums[--num_idx];

					char op = (char) chstack[--chs_idx];

					int result = calculate(num1, num2, op);

					nums[num_idx++] = result;
				}
				chs_idx--;
			} else {
				if (last != ')') {
					nums[num_idx++] = num;
					num = 0;
				}

				if (ch == '+' || ch == '-') {
					while (chs_idx != 0 && chstack[chs_idx - 1] != '(') {
						int num2 = nums[--num_idx];
						int num1 = nums[--num_idx];

						char op = (char) chstack[--chs_idx];

						int result = calculate(num1, num2, op);

						nums[num_idx++] = result;
					}
					chstack[chs_idx++] = ch;
				} else {
					while (chs_idx != 0 &&chstack[chs_idx - 1] != '(' && chstack[chs_idx - 1] != '+' && chstack[chs_idx - 1] != '-') {
						int num2 = nums[--num_idx];
						int num1 = nums[--num_idx];

						char op = (char) chstack[--chs_idx];

						int result = calculate(num1, num2, op);

						nums[num_idx++] = result;
					}

					chstack[chs_idx++] = ch;
				}
			}
			last = ch;
		}

		if (last != ')')
			nums[num_idx++] = num;
		while (chs_idx != 0) {
			int num2 = nums[--num_idx];
			int num1 = nums[--num_idx];

			char op = (char) chstack[--chs_idx];

			int result = calculate(num1, num2, op);

			nums[num_idx++] = result;
		}

		return nums[0];
	}

	public int calculate(int a, int b, char op) {
		switch (op) {
			case '+':
				return a + b;
			case '-':
				return a - b;
			case '*':
				return a * b;
			default:
				return a / b;
		}
	}
}