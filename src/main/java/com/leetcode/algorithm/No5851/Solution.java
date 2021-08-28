package com.leetcode.algorithm.No5851;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/22 16:37
 */
public class Solution {
	public String findDifferentBinaryString(String[] nums) {
		int n = nums[0].length();
		boolean[] map = new boolean[(int) (Math.pow(2, n))];
		for (int i = 0; i < nums.length; i++) {
			map[parse(n, nums[i])] = true;
		}

		while (true) {
			int rnd = (int) (Math.random() * (int) (Math.pow(2, n)));
			if (!map[rnd])
				return parse(n, rnd);
		}
	}

	private String parse(int n, int num) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			builder.append((char) ((num & 1) + '0'));
			num >>= 1;
		}
		return builder.reverse().toString();
	}

	private int parse(int n, String s) {
		char[] chs = s.toCharArray();
		int num = 0;
		for (int i = 0; i < n; i++) {
			num <<= 1;
			num += chs[i] - '0';
		}
		return num;
	}
}