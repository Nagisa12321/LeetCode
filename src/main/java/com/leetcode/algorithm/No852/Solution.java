package com.leetcode.algorithm.No852;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/15 9:45
 */
public class Solution {
	public int peakIndexInMountainArray(int[] arr) {
		int lo = 0, hi = arr.length;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] < arr[mid + 1]) lo = mid + 1;
			else hi = mid - 1;
		}
		return lo;
	}
}