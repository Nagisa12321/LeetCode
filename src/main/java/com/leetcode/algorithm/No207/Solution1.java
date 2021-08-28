package com.leetcode.algorithm.No207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/6 17:07
 */
public class Solution1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] lists = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			lists[i] = new ArrayList<>();
		}
		for (int i = 0; i < prerequisites.length; i++) {
			lists[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		// 入度表
		int[] indegrees = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			for (int after : lists[i])
				indegrees[after]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		int courses = numCourses;
		// 度数为0的先入队
		for (int i = 0; i < numCourses; i++) {
			if (indegrees[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			courses--;

			// delete the cur
			for (int after : lists[cur]) {
				if (--indegrees[after] == 0)
					queue.offer(after);
			}
		}

		return courses == 0;
	}
}