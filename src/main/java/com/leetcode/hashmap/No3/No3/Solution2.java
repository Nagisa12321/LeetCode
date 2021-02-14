package com.leetcode.hashmap.No3.No3;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/6 10:42
 */
public class Solution2 {
    // ��ɢ�б�ģ�����
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var set = new HashSet<Integer>();

        if (k >= nums.length) {
            for (int i = 0; i < nums.length; i++)
                if (!set.add(nums[i])) return true;
            return false;
        } else {
            // �Ƚ� k ��Ԫ��
            for (int i = 0; i < k; i++)
                if (!set.add(nums[i])) return true;
            // ά�ֳ���Ϊ k �Ļ�������
            for (int i = 0; i < nums.length - k; i++) {
                if (!set.add(nums[i + k])) return true;
                set.remove(nums[i]);
            }
        }
        return false;
    }
}