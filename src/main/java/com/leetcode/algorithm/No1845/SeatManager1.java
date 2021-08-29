package com.leetcode.algorithm.No1845;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/24 10:46
 */
public class SeatManager1 {

	private TreeSet<Integer> set;

	public SeatManager1(int n) {
		set = new TreeSet<>();
		for (int i = 1; i <= n; i++) {
			set.add(i);
		}
	}

	public int reserve() {
		int res = set.first();
		set.remove(res);
		return res;
	}

	public void unreserve(int seatNumber) {
		set.add(seatNumber);
	}
}