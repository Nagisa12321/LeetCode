package com.leetcode.primary.No1.No6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @追逐竞争法
 */
public class Solution3 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0, b = 0;
        while (a != nums1.length && b != nums2.length) {
            if (nums1[a] < nums2[b]) ++a;
            else if (nums1[a] > nums2[b]) ++b;
            else {
                list.add(nums1[a++]);
                b++;
            }
        }
        int[] re = new int[list.size()];
        for (int i = 0; i < re.length; ++i)
            re[i] = list.get(i);
//        return list.stream().mapToInt(Integer::valueOf).toArray();  //很慢！
        return re;
    }
}
