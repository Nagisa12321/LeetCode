package com.leetcode.algorithm.No215;

import java.util.Arrays;

/**
 * @方法： 使用普通排序，但只遍历k次,求出每次的最大值，
 *        时间复杂度太高了！
 */
public class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        for(int i = 0;i < k;i++){
            int theMax = nums[i];
            int theIndex = i;
            for(int j = i;j < nums.length ;j++){
                if(nums[j] > theMax){
                    theMax = nums[j];
                    theIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[theIndex];
            nums[theIndex] = temp;
        }
        return nums[k - 1];
    }
}
