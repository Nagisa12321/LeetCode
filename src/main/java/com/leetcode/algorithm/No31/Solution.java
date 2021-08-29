package com.leetcode.algorithm.No31;

public class Solution {
    public void nextPermutation(int[] nums) {
        int right = nums.length - 1;
        int l = 0 , h = 0;
        boolean hasPermutation = false;
        while (right > 0){
            int left = right - 1;
            while (left>=0 && nums[left] >= nums[right])
                left--;
            if(left>=0 && nums[left] < nums[right]) {
                hasPermutation = true;

            }
            right--;
        }
        if(!hasPermutation){
            for(int i = 0;i < nums.length - 1;++i){
                int temp = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        }
    }
}
