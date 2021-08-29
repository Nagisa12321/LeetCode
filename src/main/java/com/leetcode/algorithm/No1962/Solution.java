package com.leetcode.algorithm.No1962;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/20 10:09
 */
public class Solution {
	public int minStoneSum(int[] piles, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
		for (int pile : piles)
			pq.offer(pile);
		for (int i = 0; i < k; i++) {
			int poll = pq.poll();
			pq.offer(poll - poll / 2);
		}
		int sum = 0;
		while (!pq.isEmpty())
			sum += pq.poll();
		return sum;
	}
}