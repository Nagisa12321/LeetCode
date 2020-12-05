package com.leetcode.offer.No45;

/**
 * @快速自定义排序
 */
public class Solution2 {
    public String minNumber(int[] nums) {
        quicksort(nums, 0, nums.length -1);
        StringBuilder theBuilder = new StringBuilder();
        for(int i : nums)
            theBuilder.append(i);
        return theBuilder.toString();
    }

    private void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int index = getIndex(nums, left, right);
            quicksort(nums, left, index - 1);
            quicksort(nums, index + 1, right);
        }
    }

    //?复制上一题的比较: 若i可在num后面，则返回ture
    private boolean compare(int num, int i) {
        return (Long.parseLong(num + "" + i) <= Long.parseLong(i + "" + num));
    }

    private int getIndex(int[] nums, int left, int right) {
        int tmp = nums[left];
        while (left < right) {
            while (compare(tmp,nums[right]) && left < right) --right;
            nums[left] = nums[right];
            while (compare(nums[left],tmp) && left < right) ++left;
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }
}
