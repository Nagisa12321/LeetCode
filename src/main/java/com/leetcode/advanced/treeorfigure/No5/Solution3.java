package com.leetcode.advanced.treeorfigure.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/27 11:39
 */
// 深度优先搜索
public class Solution3 extends Solution {

	public int findCircleNum(int[][] isConnected) {
		int len = isConnected.length;
		int[] city = new int[len];

		int count = 0;
		for (int i = 0; i < len; i++) {
			if (city[i] == 0) {
				dfs(isConnected, city, i);
				count++;
			}
		}

		return count;
	}

	public void dfs(int[][] isConnected, int[] city, int idx) {
		if (city[idx] == 1) return;
		city[idx] = 1;

		for (int i = 0; i < city.length; i++) {
			if (isConnected[idx][i] == 1)
				dfs(isConnected, city, i);
		}
	}
}
