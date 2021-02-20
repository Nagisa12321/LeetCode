package com.leetcode.offer.No53.missingnumber;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/16 22:37
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (mid == 0) {
                if (nums[0] == 0) lo++;
                else return 0;
            }
            else if (nums[mid] == nums[mid - 1] + 2) return nums[mid] - 1;
            else if (mid == nums[mid]) lo = mid + 1;
            else hi = mid - 1;
        }

        return nums.length;
    }
}