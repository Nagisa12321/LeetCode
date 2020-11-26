package com.leetcode.algorithm.No44;

import java.util.Stack;

public class Solution2 {
	public int trap(int[] height) {
		int sumOfWater = 0;
		Stack<Integer> theStack = new Stack<>();
		for (int theCurrent = 0; theCurrent < height.length; theCurrent++) {
			while(!theStack.isEmpty()&&height[theCurrent]>height[theStack.peek()]) {
				int h = height[theStack.peek()];
				theStack.pop();
				if(theStack.isEmpty())
					break;
				int disteace = theCurrent - theStack.peek() -1;
				int min = Math.min(height[theCurrent], height[theStack.peek()]);
				sumOfWater += disteace*(min - h);
			}
			theStack.push(theCurrent);
		}
		return sumOfWater;
	}
}
