package com.leetcode.algorithm.No40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/4 9:38
 */
public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		trace(result, list, candidates, 0, target);
		return result;
	}

	private void trace(List<List<Integer>> result, List<Integer> list, int[] candidates, int idx, int target) {
		if (target < 0) return;
		else if (target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = idx; i < candidates.length; i++) {
			if (i != idx && candidates[i] == candidates[i - 1])
				continue;
			list.add(candidates[i]);
			trace(result, list, candidates, i + 1, target - candidates[i]);
			list.remove(list.size() - 1);
		}
	}
}