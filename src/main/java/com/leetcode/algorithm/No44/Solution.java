package com.leetcode.algorithm.No44;

//�÷������У�Ȼ��Forѭ��̫�࣬����ʱ������
public class Solution {
	public int trap(int[] height) {
		// �ҳ����߶�
		int round = 0;
		for (int k : height) {
			if (k > round)
				round = k;
		}
		int left, right;
		int sumOfWater = 0;
		for (int j = 0; j < round; j++) {

			// ǰ��������飬�ų���ֵС�ڻ����0
			// ������С��0��sum+=����ֵ
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

			// ���������һ
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
