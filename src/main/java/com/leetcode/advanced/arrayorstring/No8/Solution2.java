package com.leetcode.advanced.arrayorstring.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/25 10:27
 */
public class Solution2 extends Solution {
    // �����ֻ�ó����� O(1) �Ķ���ռ������������
    // ��������һ��ʱ�临�Ӷ�С�� O(n2) �Ľ��������
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
