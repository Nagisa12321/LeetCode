package com.leetcode.algorithm.No331;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 21:01
 */
public class Solution {
	public boolean isValidSerialization(String preorder) {
		String[] strs = preorder.split(",");
		int stack = 0;
		int direction = 0; // 0 --> left, 1 --> right

		for (String str : strs) {
			if (str.equals("#")) {
				if (direction == 0) direction = 1;
				else if (stack == 0) return false;
				else stack--;
			} else {
				if (direction == 0) stack++;
				else if (stack == 0) return false;
				else direction = 0;
			}
		}

		return stack == 0;
	}
}