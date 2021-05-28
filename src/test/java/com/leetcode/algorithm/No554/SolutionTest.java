package com.leetcode.algorithm.No554;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution2 solution = new Solution2();
		// wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1, 2, 2, 1));
		list.add(Arrays.asList(3, 1, 2));
		list.add(Arrays.asList(1, 3, 2));
		list.add(Arrays.asList(2, 4));
		list.add(Arrays.asList(3, 1, 2));
		list.add(Arrays.asList(1, 3, 1, 1));

		System.out.println(solution.leastBricks(list));
	}
}