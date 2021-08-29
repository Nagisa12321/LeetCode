package com.leetcode.offer.No39;

import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 10:06
 */
public class Solution4 {
    public int majorityElement(int[] nums) {

        Random random = new Random();
        while (true) {
            /*
            ���شӴ����������������������ȡ��α�����
            ���ȷֲ���ֵ��0����������ָ��ֵ����������֮���intֵ��
            nextInt��һ���ͬ��α������ɲ�����ָ����Χ�ڵ�һ��intֵ��
            ����bound���ܵ�intֵ�ԣ����ƣ���ȵĸ��ʲ�����
             */
            int test = random.nextInt(nums.length);
            int times = 0;
            for (int num : nums) {
                if (num == nums[test]) times++;
                if (times >= nums.length / 2) return nums[test];
            }
        }
    }
}
