package com.leetcode.algorithm.No739;

import java.util.Stack;

/**
 * 通过单调栈实现
 */
public class Solution {
    class List {
        public int value;
        public int index;

        public List(int value, int index) {
            this.index = index;
            this.value = value;
        }
    }
    private Stack<List> theStack = new Stack<>();

    public int[] dailyTemperatures(int[] T) {
        //利用theArray来记录最后输出数组
        int[] theArray = new int[T.length];
        for (int index = 0; index != T.length; ++index) {
            //栈空,或者小于栈顶元素则直接入栈
            if (theStack.isEmpty() || T[index] <= theStack.peek().value)
                theStack.push(new List(T[index], index));
                //大于栈顶元素
            else {
                //如果栈顶一直小于要进入元素，则一直出栈，并且在新的数组中记录值
                while (!theStack.isEmpty() && T[index] > theStack.peek().value)
                    theArray[theStack.peek().index] = index - theStack.pop().index;
                theStack.push(new List(T[index],index));
            }
        }
        return theArray;
    }
}

