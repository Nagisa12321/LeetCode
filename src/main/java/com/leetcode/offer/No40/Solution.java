package com.leetcode.offer.No40;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/4 20:16
 */
public class Solution {
	public int[] getLeastNumbers(int[] arr, int k) {
		Arrays.sort(arr);
		int[] result = new int[k];

		for (int i = 0; i < k; i++)
			result[i] = arr[i];

		return result;
	}
}