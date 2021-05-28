package com.leetcode.week.No236.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/11 11:04
 */
public class Solution {
	public int findTheWinner(int n, int k) {
		int[] f = new int[n + 1];
		f[1] = 0;
		for (int i = 2; i <= n; i++) {
			f[i] = (f[i - 1] + k) % i;
		}
		return f[n] + 1;
	}
}