package com.leetcode.advanced.arrayorstring.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/25 10:27
 */
public class Solution2 extends Solution {
    // 你可以只用常量级 O(1) 的额外空间解决这个问题吗？
    // 你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？
    @Override
    public int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];
        fast = nums[nums[fast]];
        slow = nums[slow];

        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = nums[0];

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}
