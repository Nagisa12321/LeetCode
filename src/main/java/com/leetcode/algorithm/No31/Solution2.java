package com.leetcode.algorithm.No31;

/**
 * @字典序算法 先找出“逆序部分”
 * 在逆序部分中找出刚好大于逆序部分前的数字并作交换
 * 排序逆序部分
 */
public class Solution2 {
    public void nextPermutation(int[] nums) {
        //记录逆序部分开始下标
        int theIndex = nums.length - 1, theLeftNum;
        //找出逆序开始之下标theIndex
        for (int i = nums.length - 1; i >= 0; --i)
            if (nums[i] >= nums[theIndex]) theIndex = i;
            else break;
        //若起始位为0则翻转数组
        if (theIndex == 0) {
            reserve(nums, 0, nums.length - 1);
        } else {
            //翻转数组之前的数字
            theLeftNum = nums[theIndex - 1];
            //刚好大于theLeftNum的数字
            int theIndex2 = theIndex;
            for (int i = theIndex; i < nums.length; ++i)
                if (nums[i] > theLeftNum) theIndex2 = i;
            //交换theLeftNum和nums[theIndex2]
            nums[theIndex - 1] = nums[theIndex2];
            nums[theIndex2] = theLeftNum;
            //逆序排序后面数字
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
