package com.leetcode.algorithm.No611;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/4 9:56
 */
public class Solution {
	public int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		if (nums.length < 3)
			return 0;
		int res = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] == 0) continue;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (nums[j] == 0) continue;
				int min = nums[j] - nums[i];
				int max = nums[j] + nums[i];
				int lo = j + 1, hi = nums.length - 1;

				// find the left
				while (lo < hi) {
					int mid = lo + (hi - lo) / 2;
					if (nums[mid] < min) lo = mid + 1;
					else hi = mid - 1;
				}
				int left = lo;
				lo = j + 1;
				hi = nums.length - 1;

				// find the right
				while (lo < hi) {
					int mid = lo + (hi - lo) / 2;
					if (nums[mid] >= max) hi = mid - 1;
					else lo = mid + 1;
				}
				int right = hi;
				if (nums[left] >= max || nums[right] <= min)
					continue;
				if (nums[right] >= max)
					right--;
				if (nums[left] <= min)
					left++;
				int tmp = right - left + 1;
				res += Math.max(tmp, 0);
			}
		}
		return res;
	}
}