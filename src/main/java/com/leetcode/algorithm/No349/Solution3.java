package com.leetcode.algorithm.No349;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 优化第一个方法
 */
public class Solution3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> theSet1 = new HashSet<Integer>();
        HashSet<Integer> theSet2 = new HashSet<Integer>();
        ArrayList<Integer> theArray = new ArrayList<Integer>();
        //set记录两个数组不重复元素
        for (int j : nums1) {
            if (!theSet1.contains(nums1))
                theSet1.add(j);
        }
        for (int j : nums2) {
            if (!theSet2.contains(nums2))
                theSet2.add(j);
        }
        for(int i = 0;i < theSet1.toArray().length;++i){
            if(theSet2.contains(theSet1.toArray()[i])){
                theArray.add((Integer) theSet1.toArray()[i]);
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
