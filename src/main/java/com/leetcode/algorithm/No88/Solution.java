package com.leetcode.algorithm.No88;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/19 11:31
 */
public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int idx = 0;
		int i1 = 0, i2 = 0;
		for (int i = 0; i < m + n; i++) {
			if (i2 >= n || nums1[i1] < nums2[i2]) {
				nums1[idx++] = nums1[i1++];
			} else {
				nums1[idx++] = nums2[i2++];
			}
		}
	}
}