package com.leetcode.algorithm.No1968;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/20 22:11
 */
public class Solution {
	public int[] rearrangeArray(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			list.add(num);
		}
		while (true) {
			if (isRear(list)) {
				int[] res = new int[list.size()];
				int idx = 0;
				for (int num : list) {
					res[idx++] = num;
				}
				return res;
			}
			Collections.shuffle(list);
		}
	}

	public boolean isRear(List<Integer> list) {
		for (int i = 1; i < list.size() - 1; i++) {
			if (list.get(i) * 2 == list.get(i - 1) + list.get(i + 1))
				return false;
		}
		return true;
	}
}