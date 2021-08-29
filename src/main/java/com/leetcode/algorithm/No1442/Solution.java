package com.leetcode.algorithm.No1442;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/18 9:31
 */
public class Solution {
	public int countTriplets(int[] arr) {
		int[] tmp = new int[arr.length + 1];
		tmp[0] = 0;

		// tmp[i] 表示第1项到第i项的异或值
		for (int i = 1; i < arr.length + 1; i++) {
			tmp[i] = arr[i - 1] ^ tmp[i - 1];
		}

		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length + 1; j++) {
				if (tmp[i] == tmp[j]) {
					res += j - i - 1;
				}
			}
		}

		return res;
	}
}