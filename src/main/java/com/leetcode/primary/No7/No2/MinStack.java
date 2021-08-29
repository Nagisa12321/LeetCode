package com.leetcode.primary.No7.No2;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/14 0:59
 * @version 1.0
 ************************************************/
public class MinStack {
    private static class Node {
        Node next;
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            Node node = new Node(x, Math.min(x, head.min));
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
