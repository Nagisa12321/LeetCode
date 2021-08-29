package com.leetcode.algorithm.No802;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/8 15:12
 */
public class Solution1 {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> res = new ArrayList<>();

		// 0 -> 未被搜索
		// 1 -> 灰色: 在栈上
		// 2 -> 安全节点
		int[] color = new int[graph.length];
		for (int from = 0; from < graph.length; from++) {
			if (!hasCycle(from, graph, color))
				res.add(from);
		}
		return res;
	}

	public boolean hasCycle(int point,
							int[][] graph,
							int[] color) {
		if (color[point] > 0)
			return color[point] == 1;
		color[point] = 1;
		for (int to : graph[point]) {
			if (hasCycle(to, graph, color))
				return true;
		}
		color[point] = 2;
		return false;
	}
}