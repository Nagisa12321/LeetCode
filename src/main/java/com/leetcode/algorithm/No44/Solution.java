package com.leetcode.algorithm.No44;

//该方法可行，然而For循环太多，超出时间限制
public class Solution {
	public int trap(int[] height) {
		// 找出最大高度
		int round = 0;
		for (int k : height) {
			if (k > round)
				round = k;
		}
		int left, right;
		int sumOfWater = 0;
		for (int j = 0; j < round; j++) {

			// 前后遍历数组，排除数值小于或等于0
			// 且若是小于0，sum+=绝对值
			for (left = 0; left < height.length; left++) {
				if (height[left] <= 0)
					sumOfWater += -height[left];
				else
					break;
			}
			for (right = height.length - 1; right >= 0; right--) {
				if (height[right] <= 0)
					sumOfWater += -height[right];
				else
					break;
			}
//			Arrays.copyOfRange(height, left, right);
			int[] temp = new int[right - left + 1];
			for (int i = 0, templeft = left; i < right - left + 1; i++) {
				temp[i] = height[templeft];
				templeft++;
			}
			height = temp;

			// 数组总体减一
			for (int i = 0; i < height.length; i++) {
				--height[i];
			}
		}
		for (int j : height) {
			sumOfWater += -j;
		}
		return sumOfWater;
	}
}
