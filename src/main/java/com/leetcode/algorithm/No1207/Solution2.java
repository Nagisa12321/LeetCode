package com.leetcode.algorithm.No1207;//HashMap 解决
import java.util.HashMap;

public class Solution2 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> theMap = new HashMap<>();
        int i = 0, index = 0;
        int[] theArray = new int[2000];
        while (i != arr.length) {
            if (theMap.containsKey(arr[i]))
                theMap.put(arr[i], theMap.get(arr[i]) + 1);
            else {
                theMap.put(arr[i], 1);
                theArray[index++] = arr[i];
            }
            ++i;
        }
        for (i = 0; i < index; i++) {
            int temp = theMap.get(theArray[i]);
            theMap.remove(theArray[i]);
            if (theMap.containsValue(temp)) return false;
        }
        return true;
    }
}
