package com.leetcode.algorithm.No313;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/14 8:54
 */
public class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		HashSet<Long> set = new HashSet<>();

		pq.offer(1L);
		set.add(1L);

		for (int i = 0; i < n - 1; i++) {
			long tmp = pq.poll();

			for (int j = 0; j < primes.length; j++) {
				if (set.add(tmp * primes[j])) {
					pq.offer(tmp * primes[j]);
				}
			}
		}

		return Math.toIntExact(pq.poll());
	}
}