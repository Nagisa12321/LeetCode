package com.leetcode.queueorstack.summary.No6;

import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/5 16:19
 */
public class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		// 从0号房间开始访问, 全部设置为未访问过
		boolean[] visited = new boolean[rooms.size()];
		visit(rooms, visited, 0);

		// 检查是否完全访问过
		for (boolean v : visited)
			if (!v) return false;
		return true;
	}

	public void visit(List<List<Integer>> rooms, boolean[] visited, int now) {
		// 当前房间访问过了, 直接return
		if (visited[now]) return;

		// 设置为访问过啦
		visited[now] = true;

		// 下一个要访问什么房间?
		List<Integer> nextRooms = rooms.get(now);
		for (int room : nextRooms)
			visit(rooms, visited, room);
	}
}