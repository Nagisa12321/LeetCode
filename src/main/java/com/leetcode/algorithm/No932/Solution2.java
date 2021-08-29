package com.leetcode.algorithm.No932;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/25 10:03
 */
public class Solution2 {
	private Map<Integer, int[]> resultMap = new HashMap<>();
	public int[] beautifulArray(int n) {
		if (resultMap.containsKey(n)) return resultMap.get(n);
		else if (n == 1) {
			int[] res = {1};
			resultMap.put(1, res);
			return res;
		} else if (n == 2) {
			int[] res = {1, 2};
			resultMap.put(2, res);
			return res;
		}

		int[] res = new int[n];
		int ridx = n / 2;
		int[] right = beautifulArray(ridx);
		int[] left = beautifulArray(n - ridx);

		int idx = 0;
		for (int k : left) { res[idx++] = k * 2 - 1; }
		for (int k : right) { res[idx++] = k * 2; }
		resultMap.put(n, res);

		return res;
	}
}