package com.leetcode.offer.No30;

/**
 * 若进入的元素比原来小，则先入栈一个原来的数以记录最小值
 * 若比原来的大，则直接入栈
 * 若出栈时发现下面的数比要出栈的数大，则原来栈中最小值为下面的数，并出栈下面的数
 * 若出栈时下面的数要小
 */
public class MinStack3 {
    private int[] data;
    private int min;
    private int i;

    public MinStack3() {
        this.i = -1;
        this.data = new int[20000];
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(min >= x){
            data[++i] = min;
            min = x;
        }
        data[++i] = x;
    }

    public void pop() {
        if(min == top()){
            min = data[--i];
        }
        --i;
    }

    public int top() {
        return data[i];
    }

    public int min() {
        return min;
    }
}
