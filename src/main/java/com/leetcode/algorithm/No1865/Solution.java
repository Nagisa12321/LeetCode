package com.leetcode.algorithm.No1865;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/4 10:14
 */
class FindSumPairs {
	private final Map<Integer, Integer> map1;
	private final Map<Integer, Integer> map2;
	private final int[] nums2;
	public FindSumPairs(int[] nums1, int[] nums2) {
		this.nums2 = nums2;
		// 值为nums[i] 的有多少
		this.map1 = new HashMap<>();
		this.map2 = new HashMap<>();
		for (int num : nums1) {
			map1.put(num, map1.getOrDefault(num, 0) + 1);
		}

		for (int num : nums2) {
			map2.put(num, map2.getOrDefault(num, 0) + 1);
		}
	}

	public void add(int index, int val) {
		int tmp = nums2[index];
		map2.put(tmp, map2.get(tmp) - 1);
		map2.put(tmp + val, map2.getOrDefault(tmp + val, 0) + 1);
		nums2[index] += val;
	}

	public int count(int tot) {
		Set<Map.Entry<Integer, Integer>> entries = map1.entrySet();
		int count = 0;
		for (Map.Entry<Integer, Integer> entry : entries) {
			int key = entry.getKey();
			count += map2.getOrDefault(tot - key, 0) * map1.get(key);
		}
		return count;
	}
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */