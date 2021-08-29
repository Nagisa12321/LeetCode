package com.leetcode.queueorstack.summary.No4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/4 10:37
 */
public class Solution2 extends Solution {
	@Override
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int x_len = image.length;
		int y_len = image[0].length;
		int oldColor = image[sr][sc];
		if (oldColor == newColor) return image;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{sr, sc});

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				assert cur != null;
				int x = cur[0];
				int y = cur[1];

				image[x][y] = newColor;
				if (x - 1 >= 0 && image[x - 1][y] == oldColor) queue.offer(new int[]{x - 1, y});
				if (x + 1 < x_len && image[x + 1][y] == oldColor) queue.offer(new int[]{x + 1, y});
				if (y - 1 >= 0 && image[x][y - 1] == oldColor) queue.offer(new int[]{x, y - 1});
				if (y + 1 < y_len && image[x][y + 1] == oldColor) queue.offer(new int[]{x, y + 1});
			}
		}
		return image;
	}
}
