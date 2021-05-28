package com.leetcode.algorithm.No621;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/15 10:01
 */
public class Solution {
	public int leastInterval(char[] tasks, int n) {
		int[] counts = new int[26];
		for (int task : tasks) {
			counts[task - 'A']++;
		}
		int max = 0; // 出现最多的次数
		for (int count : counts) {
			max = Math.max(count, max);
		}

		int maxCount = 0;
		for (int count : counts) {
			if (count == max) {
				maxCount++;
			}
		}

		return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
	}
}