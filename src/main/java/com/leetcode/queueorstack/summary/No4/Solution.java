package com.leetcode.queueorstack.summary.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/4 10:36
 */
public class Solution {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int oldColor = image[sr][sc];
		if (oldColor == newColor) return image;
		dfs(image, sr, sc, newColor, oldColor);
		return image;
	}

	public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;

		if (image[sr][sc] != oldColor) return;

		image[sr][sc] = newColor;

		dfs(image, sr - 1, sc, newColor, oldColor);
		dfs(image, sr + 1, sc, newColor, oldColor);
		dfs(image, sr, sc - 1, newColor, oldColor);
		dfs(image, sr, sc + 1, newColor, oldColor);
	}
}