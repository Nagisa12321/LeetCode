package com.leetcode.advanced.arrayorstring.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/25 10:26
 */
public class Solution {
    // ���޸����� nums ������½���������
    // ʱ�临�Ӷ�С�� O(n2) �Ľ������
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] map = new int[len - 1];

        for (int num : nums) {
            if (map[num - 1] == 0)
                map[num - 1]++;
            else return num;
        }
        return 0;
    }
}