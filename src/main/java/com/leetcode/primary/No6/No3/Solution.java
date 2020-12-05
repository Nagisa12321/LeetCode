package com.leetcode.primary.No6.No3;

/************************************************
 * @description ��̬�滮
 * @author jtchen
 * @date 2020/12/3 11:35
 * @version 1.0
 ************************************************/
public class Solution {
    public int maxSubArray(int[] nums) {
        //f[i]����iΪ��β�����������Ĵ�С��
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; ++i)
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
        int max = Integer.MIN_VALUE;
        for(int i : f)
            max = Math.max(i,max);
        return max;
    }
}
