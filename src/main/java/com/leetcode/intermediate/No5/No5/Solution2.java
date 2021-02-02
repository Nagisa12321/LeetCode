package com.leetcode.intermediate.No5.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/27 10:33
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        // 连续两次二分查找
        int lo = 0, hi = nums.length - 1;
        int left = -1, right = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                if ((mid - 1 == -1 || nums[mid - 1] != target)) {
                    left = mid;
                    break;
                }
                else hi = mid - 1;
            }
            else if (target < nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        }

        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                if ((mid + 1 == nums.length || nums[mid + 1] != target)) {
                    right = mid;
                    break;
                }
                else lo = mid + 1;
            }
            else if (target < nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        }

        return new int[]{left, right};
    }
}