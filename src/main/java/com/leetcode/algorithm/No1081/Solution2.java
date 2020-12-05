package com.leetcode.algorithm.No1081;

import java.util.Stack;

/**
 * @Stack "看一眼后续"，在入栈
 * 若栈空则直接入栈
 * 若比栈顶元素大，则直接入栈
 * 若比栈顶元素小，则“看一眼”后续串
 * 若出现，则出栈，再看看栈顶……
 * 若没出现，则直接出栈
 */
public class Solution2 {
    public String smallestSubsequence(String s) {
        var theStack = new Stack<Character>();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char tmp = s.charAt(0);
            s = s.substring(1);
            if (theStack.isEmpty())
                theStack.push(tmp);
            else if (tmp >= theStack.peek() && !theStack.contains(tmp))
                theStack.push(tmp);
            else if (tmp < theStack.peek()) {
                if (!theStack.contains(tmp)) {
                    while (!theStack.isEmpty() && s.indexOf(theStack.peek()) != -1 && tmp < theStack.peek())
                        theStack.pop();
                    theStack.push(tmp);
                }
            }
        }
        StringBuilder theBuilder = new StringBuilder();
        while (!theStack.isEmpty())
            theBuilder.append(theStack.pop());
        return theBuilder.reverse().toString();
    }
}