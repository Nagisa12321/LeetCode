package com.leetcode.algorithm.No56;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/8 23:42
 */
public class Solution {
	public int[][] merge(int[][] intervals) {
		// 按起始地址排好
		Arrays.sort(intervals, (x, y) -> { return x[0] - y[0]; });
		int idx = 1; // 新的数组的长度

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[idx - 1][1] >= intervals[i][0]) {
				intervals[idx - 1][1] = Math.max(intervals[i][1], intervals[idx - 1][1]);
			} else {
				intervals[idx] = intervals[i];
				idx++;
			}
		}
		int[][] res = new int[idx][2];
		if (idx >= 0) System.arraycopy(intervals, 0, res, 0, idx);
		return res;
	}
}