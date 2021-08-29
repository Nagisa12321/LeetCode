package com.leetcode.primary.No1.No6;

import java.util.ArrayList;
import java.util.Collections;

/**最笨方法
 * @ArrayList 把nums1存入List之中，遍历nums2，若不存在则删去List中元素
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> theList = new ArrayList<>();
        ArrayList<Integer> theList2 = new ArrayList<>();
        for (int i : nums1) theList.add(i);
        for (int j : nums2) if (theList.contains(j)) {
            theList2.add(j);
            theList.remove((Object)j);
        }
        int[] re = new int[theList2.size()];
        for (int i = 0; i < re.length; ++i)
            re[i] = (int) theList2.get(i);
        return re;
    }
}
