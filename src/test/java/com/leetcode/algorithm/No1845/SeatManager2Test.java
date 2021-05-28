package com.leetcode.algorithm.No1845;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeatManager2Test {
	@Test
	public void test1() {
		SeatManager2 manager = new SeatManager2(5);
		System.out.println(manager.reserve());
		System.out.println(manager.reserve());
		manager.unreserve(2);
		System.out.println(manager.reserve());
		System.out.println(manager.reserve());
		System.out.println(manager.reserve());
		System.out.println(manager.reserve());
		manager.unreserve(5);
	}
}