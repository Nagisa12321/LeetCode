package com.leetcode.offer.No59.slideWindows;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/9 9:54
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];

        // �ҳ����ֵ
        int max = nums[0];
        for (int i = 1; i < k; i++)
            max = Math.max(max, nums[i]);

        int left = 0, right = k - 1;
        res[left] = max;

        while (right < nums.length - 1) {
            // ���������������ֵ��, �򲻹ܳ�ȥ����
            // ֱ�Ӱ����ֵ����Ϊ����������
            if (nums[right + 1] > max) {
                max = nums[++right];
                left++;
            } else if (nums[left] == max) {
                // ����ȥ�����������ֵ
                // �����±����ҳ����ֵ
                left++;
                right++;
                max = nums[left];
                for (int i = left; i <= right; i++)
                    max = Math.max(max, nums[i]);
            } else {
                ++left;
                ++right;
            }
            res[left] = max;
        }
        return res;
    }
}