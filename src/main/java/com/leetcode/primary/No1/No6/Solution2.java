package com.leetcode.primary.No1.No6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @映射法
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> theMap = new HashMap<>();
        //记录映射
        for (int i : nums1) {
            if (theMap.containsKey(i)) theMap.put(i, theMap.get(i) + 1);
            else theMap.put(i, 1);
        }
        ArrayList<Integer> theList = new ArrayList<>();
        for (int i : nums2) {
            if (theMap.containsKey(i)) {
                theList.add(i);
                if (theMap.get(i) == 1) theMap.remove(i);
                else if (theMap.get(i) > 1) theMap.put(i, theMap.get(i) - 1);
            }
        }
        Stream<Integer> stream = theList.stream().map(Integer::new);
        Integer[] a = stream.toArray(Integer[]::new);
        int[] re = Arrays.stream(a).mapToInt(Integer::valueOf).toArray();
//        int[] re = new int[theList.size()];
//        for (int i = 0; i < re.length; ++i)
//            re[i] = theList.get(i);
        return re;
    }
}
