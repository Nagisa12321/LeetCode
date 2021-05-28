package com.leetcode.interview.No17.No10;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/27 10:08
 */
public class Solution {
	public int majorityElement(int[] nums) {
		int nowNum = nums[0];
		int weight = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nowNum) {
				weight++;
			} else {
				weight--;
				if (weight == 0) {
					nowNum = nums[i];
					weight = 1;
				}
			}
		}
		int times = 0;
		for (int num : nums) { if (num == nowNum) times++; }
		if (times > nums.length / 2)
			return nowNum;
		else return -1;
	}
}