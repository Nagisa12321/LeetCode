package com.leetcode.offer.No59.queue;

import java.util.Stack;

/**@用栈来表示队列
 * 用一个辅助队列存储值
 * 辅助队列为单调队列
 * 主要体现在入队时，若队空，或者入队的数小于队尾的 数，则直接入队
 * 若大于的话，则队尾出队，直到满足入队的数小于队尾的数，或者队空
 */
class MaxQueue {
    private Stack<Integer> theStack, theMonotonicStack;

    public MaxQueue() {
        this.theMonotonicStack = new Stack<>();
        this.theStack = new Stack<>();
    }

    public int max_value() {
        if (!theMonotonicStack.isEmpty())
            return theMonotonicStack.get(0);
        else return -1;
    }

    public void push_back(int value) {
        theStack.push(value);
        while (!theMonotonicStack.isEmpty() && value > theMonotonicStack.peek()) {
            theMonotonicStack.pop();
        }
        theMonotonicStack.push(value);
    }

    public int pop_front() {
        if (!theStack.isEmpty()) {
            int temp = theStack.remove(0);
            if(temp == theMonotonicStack.get(0))
                theMonotonicStack.remove(0);
            return temp;
        } else return -1;
    }

}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */