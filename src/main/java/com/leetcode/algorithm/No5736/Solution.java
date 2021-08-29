package com.leetcode.algorithm.No5736;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/18 10:55
 */
public class Solution {
	public int[] getOrder(int[][] tasks) {
		int len = tasks.length;
		int[][] idxTasks = new int[len][3];
		for (int i = 0; i < len; i++) {
			idxTasks[i][0] = tasks[i][0]; // in time
			idxTasks[i][1] = tasks[i][1]; // pay
			idxTasks[i][2] = i; // idx
		}

		Arrays.sort(idxTasks, Comparator.comparing(x -> x[0]));
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
			if (x[1] != y[1]) return x[1] - y[1];
			else return x[2] - y[2];
		});

		int nowTime = idxTasks[0][0];
		int[] result = new int[len];
		int result_idx = 0, idx = 0;
		while (idx < len && idxTasks[idx][0] <= nowTime) {
			pq.offer(idxTasks[idx++]);
		}

		while (true) {
			int[] task;
			if (!pq.isEmpty()) {
				task = pq.poll(); // 拿出一个任务并且开始执行
				result[result_idx++] = task[2];
			} else {
				int[] tmpTask = idxTasks[idx++];
				nowTime = tmpTask[0];
				pq.offer(tmpTask);
				continue;
			}

			if (result_idx == len) break;

			nowTime += task[1];

			while (idx < len && idxTasks[idx][0] <= nowTime) {
				pq.offer(idxTasks[idx++]);
			}
		}

		return result;
	}
}