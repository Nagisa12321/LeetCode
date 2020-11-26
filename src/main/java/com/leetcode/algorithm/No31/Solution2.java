package com.leetcode.algorithm.No31;

/**
 * @�ֵ����㷨 ���ҳ������򲿷֡�
 * �����򲿷����ҳ��պô������򲿷�ǰ�����ֲ�������
 * �������򲿷�
 */
public class Solution2 {
    public void nextPermutation(int[] nums) {
        //��¼���򲿷ֿ�ʼ�±�
        int theIndex = nums.length - 1, theLeftNum;
        //�ҳ�����ʼ֮�±�theIndex
        for (int i = nums.length - 1; i >= 0; --i)
            if (nums[i] >= nums[theIndex]) theIndex = i;
            else break;
        //����ʼλΪ0��ת����
        if (theIndex == 0) {
            reserve(nums, 0, nums.length - 1);
        } else {
            //��ת����֮ǰ������
            theLeftNum = nums[theIndex - 1];
            //�պô���theLeftNum������
            int theIndex2 = theIndex;
            for (int i = theIndex; i < nums.length; ++i)
                if (nums[i] > theLeftNum) theIndex2 = i;
            //����theLeftNum��nums[theIndex2]
            nums[theIndex - 1] = nums[theIndex2];
            nums[theIndex2] = theLeftNum;
            //���������������
            reserve(nums, theIndex, nums.length - 1);
        }
    }

    public int[] reserve(int[] nums, int left, int right) {
        int temp;
        for (int i = 0; i < (right - left) / 2 + 1; ++i) {
            temp = nums[left + i];
            nums[left + i] = nums[right - i];
            nums[right - i] = temp;
        }
        return nums;
    }
}
