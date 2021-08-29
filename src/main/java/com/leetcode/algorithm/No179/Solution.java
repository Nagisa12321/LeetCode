package com.leetcode.algorithm.No179;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/13 13:05
 */
public  class Solution {
	public String largestNumber(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) list.add(num);

		list.sort((num1, num2) -> {
			long tmp1 = (long) ((long) num1 * Math.pow(10, (num2.toString().length())) + num2);
			long tmp2 = (long) ((long) num2 * Math.pow(10, (num1.toString().length())) + num1);

			return Long.compare(tmp2, tmp1);
		});

		StringBuilder builder = new StringBuilder();
		for (Integer integer : list)
			builder.append(integer);

		return builder.toString();
	}
}