package com.leetcode.algorithm.No349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 双指针方法，先对两个数组进行排序，然后指针小的右移，相同则计入set
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> theSet = new HashSet<Integer>();
        int left = 0, right = 0;
        while (left != nums1.length && right != nums2.length) {
            while (nums1[left] < nums2[right])
                if (left + 1 != nums1.length) left++;
            while (nums1[left] > nums2[right])
                if (right + 1 != nums2.length)right++;
            if (nums1[left] == nums2[right]) {
                if (!theSet.contains(nums1[left]))
                    theSet.add(nums1[left]);
                right++;
            }
        }
        Object[] a = theSet.toArray();
        int[] newArray = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            newArray[i] = Integer.parseInt(a[i].toString());
        }
        return newArray;
    }
}
