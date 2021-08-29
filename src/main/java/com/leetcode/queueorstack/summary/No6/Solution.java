package com.leetcode.queueorstack.summary.No6;

import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/5 16:19
 */
public class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		// ��0�ŷ��俪ʼ����, ȫ������Ϊδ���ʹ�
		boolean[] visited = new boolean[rooms.size()];
		visit(rooms, visited, 0);

		// ����Ƿ���ȫ���ʹ�
		for (boolean v : visited)
			if (!v) return false;
		return true;
	}

	public void visit(List<List<Integer>> rooms, boolean[] visited, int now) {
		// ��ǰ������ʹ���, ֱ��return
		if (visited[now]) return;

		// ����Ϊ���ʹ���
		visited[now] = true;

		// ��һ��Ҫ����ʲô����?
		List<Integer> nextRooms = rooms.get(now);
		for (int room : nextRooms)
			visit(rooms, visited, room);
	}
}