package com.leetcode.algorithm.No781;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/4 18:29
 */
public class Solution {
	public int numRabbits(int[] answers) {
		int[] map = new int[1000];
		int rabbits = 0;

		for (int answer : answers) {
			if (answer == 0) {
				rabbits++;
				continue;
			}
			else if (map[answer] >= answer + 1) {
				rabbits += map[answer];
				map[answer] = 0;
			}
			map[answer]++;
		}

		for (int i = 0; i < 1000; i++) {
			if (map[i] != 0) rabbits += i + 1;
		}

		return rabbits;
	}
}