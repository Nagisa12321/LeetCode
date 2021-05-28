package com.leetcode.algorithm.No447;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 15:07
 */
public class Solution {
	// ±©Á¦
	public int numberOfBoomerangs(int[][] points) {
		int len = points.length;
		int[][] map = new int[len][len];
		int result = 0;

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				int i_x = points[i][0];
				int i_y = points[i][1];
				int j_x = points[j][0];
				int j_y = points[j][1];

				int distance = (i_x - j_x) * (i_x - j_x) + (i_y - j_y) * (i_y - j_y);
				map[i][j] = distance;
			}
		}

		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				for (int k = j + 1; k < len; k++) {
					if (map[i][j] == map[j][k]) result += 2;
					if (map[i][k] == map[j][k]) result += 2;
					if (map[i][j] == map[i][k]) result += 2;
				}
			}
		}

		return result;
	}
}