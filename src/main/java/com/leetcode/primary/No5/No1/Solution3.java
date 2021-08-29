package com.leetcode.primary.No5.No1;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/1 16:35
 * @version 1.0
 ************************************************/
public class Solution3 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1, b = n - 1, i = m + n - 1;
        while (i >= 0)
            if (a >= 0 && b >= 0)
                if (nums1[a] <= nums2[b]) nums1[i--] = nums2[b--];
                else nums1[i--] = nums1[a--];
            else if (a < 0) nums1[i--] = nums2[b--];
            else nums1[i--] = nums1[a--];
    }
}
