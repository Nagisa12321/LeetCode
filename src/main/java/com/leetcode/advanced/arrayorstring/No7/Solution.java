package com.leetcode.advanced.arrayorstring.No7;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/24 12:58
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int max = 1;

        // id[] ���������ڵ� sz[] ����ͳ�Ƴ��ִ���
        int[] id = new int[len];
        int[] sz = new int[len];

        for (int i = 0; i < len; i++) {
            // ����map֮��
            map.put(nums[i], i);

            // ��ʼ��id[], sz[]
            id[i] = i;
            sz[i] = 1;
        }

        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) != i) continue;

            int idx = -1;
            // �Ƿ����������ֳ���?
            if (map.containsKey(nums[i] - 1))
                idx = map.get(nums[i] - 1);
            /*else if (map.containsKey(nums[i] + 1))
                idx = map.get(nums[i] + 1);*/

            // ���������Ӧ��nums[i] ��1����С1������
            if (idx != -1) {

                // ���¶�������
                id[i] = idx;

                // �����С
                int tmp = idx;
                while (id[tmp] != tmp)
                    tmp = id[tmp];
                sz[tmp] += sz[i];

                // ��¼���ֵ
                max = Math.max(max, sz[tmp]);
            }
        }

        return max;
    }
}