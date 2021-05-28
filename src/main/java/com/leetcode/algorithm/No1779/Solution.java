package com.leetcode.algorithm.No1779;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/5 1:55
 */
public class Solution {
	public int nearestValidPoint(int x, int y, int[][] points) {
		int index = -1;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < points.length; i++) {
			int x1 = points[i][0];
			int y1 = points[i][1];
			if (x1 != x && y1 != y) continue;
			int distenct = Math.abs(x - x1) + Math.abs(y - y1);
			if (distenct < min) {
				min = distenct;
				index = i;
			}
		}

		return index;
	}
}