package com.leetcode.algorithm.No26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (right != nums.length) {
            if (nums[right] != nums[left])
                nums[++left] = nums[right];
            right++;
        }
        return left+1;
    }
}
