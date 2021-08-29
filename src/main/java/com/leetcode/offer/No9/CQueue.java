package com.leetcode.offer.No9;

import java.util.Stack;

public class CQueue {
    private Stack<Integer> theStackA;

    public CQueue() {
        theStackA = new Stack<>();
    }

    public void appendTail(int value) {
        theStackA.push(value);
    }

    public int deleteHead() {
        if (!theStackA.isEmpty())
            return theStackA.remove(0);
        else return -1;
    }

    public int[] getQueue() {
        int[] a = new int[theStackA.size()];
        for (int i = 0; i < theStackA.size(); ++i) {
            a[i] = theStackA.get(i);
        }
        return a;
    }
}
