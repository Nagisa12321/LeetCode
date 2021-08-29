package com.leetcode.algorithm.No1207; /**
 * @方法： hashset
 */

import java.util.HashSet;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] theArray = new int[2001];
        for (int j : arr)
            theArray[j + 1000]++;
        HashSet<Integer> theSet = new HashSet<>();
        for (int j : theArray)
            if (j > 0 && !theSet.add(j))
                return false;
        return true;
    }
}