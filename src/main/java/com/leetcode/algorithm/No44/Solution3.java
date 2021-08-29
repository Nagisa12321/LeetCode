package com.leetcode.algorithm.No44;

import java.util.Stack;

public class Solution3 {
    public int trap(int[] height) {
        int theCurrent = 0;
        Stack<Integer> theStack = new Stack<>();
        int sum = 0;
        for (; theCurrent < height.length; theCurrent++) {
            int theMediumHeight = 0, theSizesHeight = 0, theDistance = 0;
            while (!theStack.isEmpty() && height[theCurrent] > height[theStack.peek()]) {
                theMediumHeight = height[theStack.pop()];
                if (!theStack.isEmpty()) {
                    theSizesHeight = Math.min(height[theStack.peek()], height[theCurrent]);
                    theDistance = theCurrent - theStack.peek() - 1;
                }
                sum += theDistance * (theSizesHeight - theMediumHeight);
            }
            theStack.push(theCurrent);
        }
        return sum;
    }
}