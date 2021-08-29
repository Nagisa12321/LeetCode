package com.leetcode.algorithm.No349;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 把第一个数组存在set中，在判断第二个数组中是否存在
 * 忽然想到动态数组也可以用set来存！
 */
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> theSet = new HashSet<Integer>();
        ArrayList<Integer> theArray = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; ++i) {
            if (!theSet.contains(nums1))
                theSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; ++i) {
            if (theSet.contains(nums2[i])) {
                theArray.add(nums2[i]);
                theSet.remove(nums2[i]);
            }
        }
        Object[] a = theArray.toArray();
        int[] newArray = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            newArray[i] = Integer.parseInt(a[i].toString());
        }
        return newArray;
    }
}
