package com.leetcode.algorithm.No1743;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/25 15:02
 */
public class Solution {
	public int[] restoreArray(int[][] adjacentPairs) {
		HashMap<Integer, Point> pMap = new HashMap<>();
		for (int i = 0; i < adjacentPairs.length; i++) {
			int v = adjacentPairs[i][0];
			int w = adjacentPairs[i][1];
			if (!pMap.containsKey(v))
				pMap.put(v, new Point(v));
			if (!pMap.containsKey(w))
				pMap.put(w, new Point(w));

			Point vP = pMap.get(v);
			Point wP = pMap.get(w);
			vP.frineds.add(wP);
			wP.frineds.add(vP);
		}
		int start = -1;

		Set<Map.Entry<Integer, Point>> entries = pMap.entrySet();
		for (Map.Entry<Integer, Point> entry : entries) {
			if (entry.getValue().frineds.size() == 1) {
				start = entry.getKey();
				break;
			}
		}
		System.out.println(start);
		Point startP = pMap.get(start);
		HashSet<Point> visit = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		dfs(visit, startP, res);
		int size = res.size();
		int idx = 0;
		int[] realRes = new int[size];
		for (int num : res) {
			realRes[idx++] = num;
		}
		return realRes;
	}

	private void dfs(HashSet<Point> visit, Point p, List<Integer> res) {
		if (!visit.add(p))
			return;
		res.add(p.val);

		for (Point point : p.frineds)
			dfs(visit, point, res);
	}

	static class Point {
		int val;
		List<Point> frineds;

		public Point(int val) {
			this.val = val;
			this.frineds = new ArrayList<>();
		}
	}
}