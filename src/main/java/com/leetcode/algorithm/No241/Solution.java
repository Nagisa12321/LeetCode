package com.leetcode.algorithm.No241;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/25 11:12
 */
public class Solution {
	public List<Integer> diffWaysToCompute(String expression) {
		// 统计有几个数字
		String[] strs = expression.split("[+\\-*/]");
		int num = strs.length;
		// 操作符下标
		int[] opIdxs = new int[num - 1];
		char[] chs = expression.toCharArray();
		int idx = 0;
		for (int i = 0; i < chs.length; i++) {
			char ch = chs[i];
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				opIdxs[idx++] = i;
			}
		}

		// 根据数字递归
		List<Integer> list = new ArrayList<>();
		if (num == 0) return list;
		else if (num == 1) {
			list.add(Integer.parseInt(strs[0]));
			return list;
		} else {
			for (int i = 0; i < num - 1; i++) {
				List<Integer> list1 = diffWaysToCompute(expression.substring(0, opIdxs[i]));
				List<Integer> list2 = diffWaysToCompute(expression.substring(opIdxs[i] + 1));

				char op = chs[opIdxs[i]];
				for (int num1 : list1) {
					for (int num2 : list2) {
						list.add(calculate(num1, num2, op));
					}
				}
			}
			return list;
		}
	}

	private int calculate(int i, int j, char op) {
		switch (op) {
			case '+': return i + j;
			case '-': return i - j;
			case '*': return i * j;
			default:  return i / j;
		}
	}
}