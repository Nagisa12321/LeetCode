package com.leetcode.algorithm.No802;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/8 15:11
 */
public class Solution {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> res = new ArrayList<>();
		for (int from = 0; from < graph.length; from++) {
			HashSet<Integer> onstack = new HashSet<>();
			if (!hasCycle(from, graph, onstack))
				res.add(from);
		}
		return res;
	}

	public boolean hasCycle(int point,
							int[][] graph,
							HashSet<Integer> onstack) {
		if (!onstack.add(point))
			return true;
		for (int to : graph[point]) {
			if (hasCycle(to, graph, onstack))
				return true;
		}
		onstack.remove(point);
		return false;
	}
}