package com.leetcode.algorithm.No11;
/**
 * 该方法不可行呀
 */

import java.util.Stack;

public class Solution {
    public int maxArea(int[] height) {
        Stack<Integer> theStack = new Stack<Integer>();
        int max = 0, theIndexOfTop = 0;
        for (int i = 0; i < height.length; ++i) {
            if (theStack.isEmpty()) {
                theStack.push(height[i]);
                theIndexOfTop = i;
            } else if (height[i] <= theStack.peek()) {
                max = Math.max(Math.min(height[i], theStack.peek()) * (i - theIndexOfTop), max);
                theStack.push(height[i]);
            } else {
                while (theStack.peek() < height[i]) {
                    theStack.pop();
                    if (theStack.isEmpty()) {
                        theIndexOfTop = i;
                        break;
                    }
                }
                if (!theStack.isEmpty())
                    max = Math.max(Math.min(height[i], theStack.peek()) * (i - theIndexOfTop), max);
                theStack.push(height[i]);
            }
        }
        return max;
    }
}
