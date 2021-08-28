package com.leetcode.algorithm.No815;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/28 18:00
 */
public class Solution {
	private HashMap<Integer, BusStop> busMap = new HashMap<>();
	public int numBusesToDestination(int[][] routes, int source, int target) {
		int lines = routes.length;
		for (int i = 0; i < lines; i++) {
			int buses = routes[i].length;
			for (int j = 0; j < buses; j++) {
				addLine(i, routes[i][j]);
			}
		}
		BusStop root = busMap.get(source);
		int step = 1;
		HashSet<Integer> meet = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int l : root.busLine) {
			if (meet.add(l))
			queue.offer(l);
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int l = queue.poll();
				int buses = routes[l].length;
				for (int j = 0; j < buses; j++) {
					if (routes[l][j] == target)
						return step;
				}

				for (int j = 0; j < buses; j++) {
					BusStop tmp = busMap.get(routes[l][j]);
					for (int tmpl : tmp.busLine) {
						if (meet.add(tmpl))
						queue.offer(tmpl);
					}
				}
			}
			step++;
		}
		return -1;
	}

	private void addLine(int line, int busStop) {
		if (busMap.containsKey(busStop)) {
			busMap.get(busStop).busLine.add(line);
		} else {
			busMap.put(busStop, new BusStop(line));
		}
	}

	private static class BusStop {
		Set<Integer> busLine;

		BusStop(int line) {
			busLine = new HashSet<>();
			busLine.add(line);
		}
	}
}