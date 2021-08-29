package com.leetcode.intermediate.No16.No01;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/31 14:20
 */
public class Solution {
	public int[] swapNumbers(int[] numbers) {
		numbers[0] ^= numbers[1];
		numbers[1] ^= numbers[0];
		numbers[0] ^= numbers[1];

		return numbers;
	}
}