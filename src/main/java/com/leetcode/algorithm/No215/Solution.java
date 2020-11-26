package com.leetcode.algorithm.No215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        for(int i = nums.length/2 - 1;i >= 0;i--){
            adjustHeap(nums,i,nums.length);
        }
        for(int i = nums.length - 1;i > nums.length - 1 - k;i--){
            swap(nums,0,i);
            adjustHeap(nums,0,i);
        }
        return nums[nums.length - k];

    }
    private static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素i
        int temp = arr[i];
        //从左节点开始，也就是2i + 1处开始
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            //如果右节点还比左节点大，那么k++，即指向右节点
            if (k + 1 < length && arr[k] < arr[k + 1])
                ++k;
            //如果子节点大于父节点，则将子节点赋值给父节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                //子节点成为新的父节点
                i = k;
            } else break;
        }
        arr[i] = temp;
    }
    private static void swap(int[] arr, int i, int k) {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
}

