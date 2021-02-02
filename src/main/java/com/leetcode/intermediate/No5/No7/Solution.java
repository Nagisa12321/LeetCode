package com.leetcode.intermediate.No5.No7;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/28 10:54
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        } else if (nums.length == 2) {
            if (nums[0] == target) return 0;
            else if (nums[1] == target) return 1;
            return -1;
        }
        int len = nums.length;
        // 先用二分查找找出"旋转点"下标(向右平移了round次)
        int round = 0;
        int hi = len - 1, lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid + 1 != len && nums[mid] > nums[mid + 1]) {
                round = mid + 1;
                break;
            } else if (nums[mid] >= nums[0]) lo = mid + 1;
            else hi = mid - 1;
        }

        // 用求余的二分查找进行查找
        hi = (len - 1 + round) % len;
        lo = round;
        int lo_real = 0;
        int hi_real = hi - round < 0 ? hi - round + len : hi - round;
        while (lo_real <= hi_real) {
            lo_real = lo - round < 0 ? lo - round + len : lo - round;
            hi_real = hi - round < 0 ? hi - round + len : hi - round;
            int mid_real = lo_real + (hi_real - lo_real) / 2;
            int mid = (mid_real + round) % len;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                lo_real = mid_real + 1;
                lo = (lo_real + round) % len;
            }
            else{
                hi_real = mid_real - 1;
                hi = (hi_real + round) % len;
            }
        }

        return -1;
    }
}