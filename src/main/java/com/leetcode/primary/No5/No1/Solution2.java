package com.leetcode.primary.No5.No1;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/1 16:22
 * @version 1.0
 ************************************************/
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = 0, b = 0, i = 0;
        int[] copy = new int[nums1.length];
        System.arraycopy(nums1, 0, copy, 0, nums1.length);
        while (i < m + n)
            if (a < m && b < n)
                if (copy[a] <= nums2[b]) nums1[i++] = copy[a++];
                else nums1[i++] = nums2[b++];
            else if (a >= m && b < n) nums1[i++] = nums2[b++];
            else nums1[i++] = copy[a++];
    }
}
