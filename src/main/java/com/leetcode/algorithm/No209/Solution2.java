package com.leetcode.algorithm.No209;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/14 15:13
 */
public class Solution2 {
	public int minSubArrayLen(int target, int[] nums) {
		int len = nums.length;
        /*
            Ç°×ººÍ: (dp)
                sums[i] = nums[0] + nums[1] + ... + nums[i]
        */
		int[] sums = new int[len];
		sums[0] = nums[0];

		for (int i = 1; i < len; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}

		int min = len + 1;
		for (int i = 0; i < len; i++) {
			int lo = i, hi = len - 1;
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				int i1 = sums[mid] - (i - 1 < 0 ? 0 : sums[i - 1]);
				if ((mid == 0 && sums[0] >= target) || (i1 >= target && sums[mid - 1] - (i - 1 < 0 ? 0 : sums[i - 1]) < target)) {
					min = Math.min(min, mid - i + 1);
					break;
				} else if (i1 < target) lo = mid + 1;
				else hi = mid - 1;
			}
		}

		return min == len + 1 ? 0 : min;
	}
}