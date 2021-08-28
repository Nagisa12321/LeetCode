package com.leetcode.algorithm.No207;

import java.util.ArrayList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/5 23:12
 */
public class Solution {
	// 有向图的环路问题? 111
	// 朴素想法 -- 记录好节点关系, 逐一进行dfs
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] lists = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			lists[i] = new ArrayList<>();
		}
		for (int i = 0; i < prerequisites.length; i++) {
			lists[prerequisites[i][1]].add(prerequisites[i][0]);
		}
		for (int i = 0; i < numCourses; i++) {
			boolean[] marked = new boolean[numCourses];
			for (int child : lists[i])
				dfs(lists, child, marked);
			if (marked[i])
				return false;
		}
		return true;
	}

	private void dfs(ArrayList<Integer>[] lists, int node, boolean[] marked) {
		if (marked[node])
			return;
		marked[node] = true;

		for (int child : lists[node])
			dfs(lists, child, marked);
	}

}