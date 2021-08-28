package com.leetcode.algorithm.No1828;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/21 13:53
 */
public class Solution {
	public int[] countPoints(int[][] points, int[][] queries) {
		int[] res = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int ins = 0;
			for (int j = 0; j < points.length; j++) {
				if (in(points[j], queries[i]))
					ins++;
			}
			res[i] = ins;
		}
		return res;
	}

	public boolean in(int[] point, int[] circle) {
		int x1 = point[0];
		int y1 = point[1];
		int x2 = circle[0];
		int y2 = circle[1];

		if (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) <= circle[2] * circle[2])
			return true;
		return false;
	}
}