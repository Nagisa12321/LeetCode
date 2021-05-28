package com.leetcode.advanced.treeorfigure.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/27 11:27
 */
// ¼ÓÈ¨µÄquick-union
public class Solution2 extends Solution {
	int[] id;
	int[] sz;
	int count;

	@Override
	public int findCircleNum(int[][] isConnected) {
		/*init*/
		int len = isConnected.length;

		id = new int[len];
		sz = new int[len];
		for (int i = 0; i < len; i++) {
			id[i] = i;
			sz[i] = 1;
		}
		count = len;
		/**/

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (isConnected[i][j] == 1) {
					union(i, j);
				}
			}
		}

		return count;
	}

	public int find(int i) {
		while (i != id[i]) i = id[i];
		return i;
	}

	public void union(int i, int j) {
		int id_i = find(i);
		int id_j = find(j);

		if (id_j == id_i) return;

		//id[id_i] = id_j;
		if (sz[id_i] > sz[id_j]) {
			sz[id_i] += sz[id_j];
			id[id_j] = id_i;
		} else {
			sz[id_j] += sz[id_i];
			id[id_i] = id_j;
		}

		count--;
	}
}
