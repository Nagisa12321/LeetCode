package com.leetcode.algorithm.No5705;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/4 18:39
 */
public class Solution {
	public boolean squareIsWhite(String coordinates) {
		// °×: true, ºÚ: false
		int x = coordinates.charAt(0) - 'a' + 1;
		int y = coordinates.charAt(1);

		if (x % 2 == 1) return y % 2 == 0;
		else return y % 2 == 1;
	}
}