package com.leetcode.intermediate.No5.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/27 9:43
 */
public class Solution2 {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}