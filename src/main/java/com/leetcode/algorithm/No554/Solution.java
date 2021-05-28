package com.leetcode.algorithm.No554;

import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/2 14:54
 */
public class Solution {
	// ³¬³öÄÚ´æ
	public int leastBricks(List<List<Integer>> wall) {
		List<Integer> firstWall = wall.get(0);
		int len = 0;
		for (int wallLen : firstWall)
			len += wallLen;
		len = len * 2 - 1;
		int[][] walls = new int[wall.size()][len];
		for (int i = 0; i < wall.size(); i++) {
			List<Integer> nowWall = wall.get(i);
			int idx = 0;
			for (int theWall : nowWall) {
				int tmp = theWall * 2 - 1;
				for (int j = 0; j < tmp; j++) {
					walls[i][idx++] = 1;
				}
				if (idx != len)
					walls[i][idx++] = 0;
			}
		}
		int min = wall.size();
		for (int i = 0; i < len; i++) {
			int tmp = 0;
			for (int j = 0; j < wall.size(); j++) {
				tmp += walls[j][i];
			}
			min = Math.min(min, tmp);
		}
		return min;
	}
}