package com.leetcode.intermediate.No5.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/27 10:22
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        if (nums.length == 0) return new int[]{-1, -1};
        else if (lo == hi && nums[lo] == target)
            return new int[]{0, 0};

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                int left = mid, right = mid;
                while (left - 1 != -1 && nums[left - 1] == nums[mid]) left--;
                while (right + 1 != nums.length && nums[right + 1] == nums[mid]) right++;
                return new int[]{left, right};

            } else if (target < nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return new int[]{-1, -1};
    }
}