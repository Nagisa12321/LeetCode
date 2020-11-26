package com.leetcode.primary.No1.No2;

import java.util.Stack;
/**
 * 用栈来解决
 */

public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        Stack<Integer> theStack = new Stack<>();
        for (int price : prices) {
            if (theStack.isEmpty())
                theStack.push(price);
            else if (theStack.peek() <= price)
                theStack.push(price);
            else {
                sum += theStack.peek() - theStack.get(0);
                theStack = new Stack<>();
                theStack.push(price);
            }
        }
        if(!theStack.isEmpty())
            sum += theStack.peek() - theStack.get(0);
        return sum;
    }
}
