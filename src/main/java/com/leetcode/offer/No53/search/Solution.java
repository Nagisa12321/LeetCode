package com.leetcode.offer.No53.search;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/16 22:17
 */
public class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, left = 0, right = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target && (mid == 0 || nums[mid] > nums[mid - 1])) {
                left = mid;
                break;
            } else if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }

        lo = left;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target && (mid + 1 == nums.length || nums[mid + 1] > nums[mid])) {
                right = mid;
                break;
            } else if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }

        return right - left + 1;
    }
}