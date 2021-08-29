package com.leetcode.offer.No30;

/**
 * 数组实现
 * 经过实践，数组还是不如链表快。~
 */
public class MinStack {
    int[][] data;
    int i;

    public MinStack() {
        data = new int[20000][2];
        i = -1;
    }

    public void push(int x) {
        ++i;
        data[i][0] = x;
        if (i > 0)
            data[i][1] = Math.min(data[i][0], data[i - 1][1]);
        else data[i][1] = data[i][0];
    }

    public void pop() {
        --i;
    }

    public int top() {
        return data[i][0];
    }

    public int min() {
        return data[i][1];
    }
}
