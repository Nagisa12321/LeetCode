package com.leetcode.offer.No39;

/**
 * ��������Ϊ Ʊ���������� ���˷���ʱ��Ϳռ临�Ӷȷֱ�Ϊ O(N)O(N) �� O(1)O(1) ��Ϊ�������ѽⷨ��
 *
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 9:53
 */
public class Solution3 {
    public int majorityElement(int[] nums) {
        int x = 0/* �����������±� */, votes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) x = i;

            if (nums[i] == nums[x]) votes++;
            else votes--;
        }

        return nums[x];
    }
}
