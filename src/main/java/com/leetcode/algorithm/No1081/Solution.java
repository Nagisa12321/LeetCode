package com.leetcode.algorithm.No1081;

import java.util.ArrayList;

/**
 * Set方法/未完成
 *
 */
public class Solution {
    public String smallestSubsequence(String s) {
        var theList = new ArrayList<Character>();
        int theIndex = 0;
        while (theIndex != s.length()){
            if(theList.contains(s.charAt(theIndex))){
                if(theList.get(theList.size() - 1) > s.charAt(theIndex)){
                    for(int i = 0;i < theIndex;i++){
                        if(theList.get(i) == s.charAt(theIndex)){
                            theList.remove(i);
                            break;
                        }
                    }
                    theList.add(s.charAt(theIndex));
                }
            }else theList.add(s.charAt(theIndex));
            ++theIndex;
        }
        StringBuilder theBuilder = new StringBuilder();
        for(Object i : theList.toArray())
            theBuilder.append(i);
        return theBuilder.toString();
    }
}
