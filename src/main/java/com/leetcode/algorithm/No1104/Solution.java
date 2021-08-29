package com.leetcode.algorithm.No1104;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/29 10:13
 */
public class Solution {
	public List<Integer> pathInZigZagTree(int label) {
		int n = 1, sum = 0;
		while (sum < label)
			sum += Math.pow(2, n++);
		ArrayList<Integer> res = new ArrayList<>();
		int tmp = 0;
		for (int floor = n; floor >= 1; --floor) {
			if (tmp++ % 2 != 0)
				res.add(findReserve(label, floor));
			else res.add(label);
			label /= 2;
		}
		for (int i = 0; i < res.size() / 2; i++) {
			int t = res.get(i);
			res.set(i, res.get(res.size() - 1 - i));
			res.set(res.size() - 1 - i, t);
		}
		return res;
	}

	public int findReserve(int num, int floor) {
		int nums = (int) Math.pow(2, floor - 1);
		return 3 * nums - 1 - num;
	}
}