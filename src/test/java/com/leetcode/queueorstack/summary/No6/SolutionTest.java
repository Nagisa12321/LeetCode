package com.leetcode.queueorstack.summary.No6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
	private final Solution solution = new Solution();

	@Test
	public void canVisitAllRooms() {

		List<Integer> l1 = List.of(1);
		List<Integer> l2 = List.of(2);
		List<Integer> l3 = List.of(3);
		List<Integer> l4 = List.of();
		ArrayList<List<Integer>> lists = new ArrayList<>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		lists.add(l4);

		System.out.println(solution.canVisitAllRooms(lists));
	}
}