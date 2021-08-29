package com.leetcode.algorithm.No1796;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/27 10:28
 */
public class Solution {
	public int secondHighest(String s) {
		boolean one = false;
		boolean two = false;
		int max_one = 0;
		int max_two = 0;

		char[] chs = s.toCharArray();

		for (char ch : chs) {
			if (ch >= '0' && ch <= '9') {
				if (!one) {
					one = true;
					max_one = ch - '0';
				} else {
					int num = ch - '0';
					if (num > max_one) {
						two = true;
						max_two = max_one;
						max_one = num;
					} else if (num < max_one) {
						if (!two) {
							two = true;
							max_two = num;
						} else if (num > max_two) {
							max_two = num;
						}
					}
				}
			}
		}

		return two ? max_two : -1;
	}
}