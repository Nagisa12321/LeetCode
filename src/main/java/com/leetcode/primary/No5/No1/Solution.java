package com.leetcode.primary.No5.No1;

import java.util.Arrays;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/1 16:15
 * @version 1.0
 ************************************************/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, nums2.length);
        Arrays.sort(nums1);
    }
}