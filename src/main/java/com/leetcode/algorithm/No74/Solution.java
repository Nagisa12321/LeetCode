package com.leetcode.algorithm.No74;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/30 13:38
 */
public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int len_i = matrix.length;
		int len_j = matrix[0].length;
		int len = len_i * len_j;

		int lo = 0, hi = len - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int tmp = matrix[mid / len_j][mid % len_j];
			if (tmp == target) return true;
			else if (tmp < target) lo = mid + 1;
			else hi = mid - 1;
		}
		return false;
	}
}