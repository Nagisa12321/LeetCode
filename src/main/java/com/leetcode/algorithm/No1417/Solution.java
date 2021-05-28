package com.leetcode.algorithm.No1417;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/26 20:20
 */
public class Solution {
	public String reformat(String s) {
		char[] chs = s.toCharArray();
		int nums = 0;
		int chars = 0;
		char[] chs_stack = new char[500];
		char[] int_stack = new char[500];
		int chs_idx = 0;
		int int_idx = 0;
		for (char ch : chs) {
			if (ch >= '0' && ch <= '9') {
				nums++;
				int_stack[int_idx++] = ch;
			} else {
				chars++;
				chs_stack[chs_idx++] = ch;
			}
		}

		if (Math.abs(chars - nums) > 1) return "";
		int nowAdd = nums >= chars ? 0 : 1;
		for (int i = 0; i < chs.length; i++) {
			if (nowAdd == 0) {
				chs[i] = int_stack[--int_idx];
				nowAdd = 1;
			} else {
				chs[i] = chs_stack[--chs_idx];
				nowAdd = 0;
			}
		}

		return new String(chs);
	}
}