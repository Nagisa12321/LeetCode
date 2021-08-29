package com.leetcode.algorithm.No5738;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/25 10:49
 */
public class Solution {
	public int sumBase(int n, int k) {
		int sum = 0;
		while (n != 0) {
			sum += n % k;
			n /= k;
		}

		return sum;
	}
}