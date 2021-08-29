package com.leetcode.algorithm.No1341;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/17 19:42
 */
public class Solution {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> list = new ArrayList<>();
		int max = 0;
		for (int candy : candies) {
			max = Math.max(max, candy);
		}
		for (int candy : candies) {
			list.add(candy + extraCandies >= max);
		}
		return list;
	}
}