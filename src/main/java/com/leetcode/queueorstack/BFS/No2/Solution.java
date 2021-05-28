package com.leetcode.queueorstack.BFS.No2;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/5 18:33
 */
public class Solution {
	private final HashMap<Integer, Integer> map = new HashMap<>();

	public int numSquares(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;

		if (map.containsKey(n))
			return map.get(n);

		int num = 1;
		int min = n;
		while (num * num <= n) {
			min = Math.min(1 + numSquares(n - num * num), min);
			num++;
		}
		map.put(n, min);
		return min;
	}
}