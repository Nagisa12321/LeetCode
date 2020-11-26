package com.leetcode.offer.No9;

import java.util.Stack;

public class CQueue2 {
    private Stack<Integer> theStackA, theStackB;

    public CQueue2() {
        theStackA = new Stack<>();
        theStackB = new Stack<>();
    }

    public void appendTail(int value) {
        theStackA.push(value);
    }

    public int deleteHead() {
        //翻转A栈到B中，然后B出栈，然后又翻转回A中
        while (!theStackA.isEmpty()) {
            theStackB.push(theStackA.pop());
        }
        if (theStackB.isEmpty()) return -1;
        int a = theStackB.pop();
        while (!theStackB.isEmpty()) {
            theStackA.push(theStackB.pop());
        }
        return a;
    }

    public int[] getQueue() {
        int[] a = new int[theStackA.size()];
        for (int i = 0; i < theStackA.size(); ++i) {
            a[i] = theStackA.get(i);
        }
        return a;
    }
}
