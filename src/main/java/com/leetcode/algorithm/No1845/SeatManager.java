package com.leetcode.algorithm.No1845;

import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/24 10:43
 */
public class SeatManager {

	private PriorityQueue<Integer> pq;

	public SeatManager(int n) {
		pq = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) { pq.offer(i); }
	}

	public int reserve() {
		return pq.poll();
	}

	public void unreserve(int seatNumber) {
		pq.offer(seatNumber);
	}
}