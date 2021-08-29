package com.leetcode.queueorstack.summary.No1;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/3 11:02
 */
public class MyQueue {
	private final Stack<Integer> stack1;
	private final Stack<Integer> stack2;

	/**
	 * Initialize your data structure here.
	 */
	public MyQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		stack1.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		if (empty()) return -1;
		else if (stack2.isEmpty()) {
			while (!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		if (empty()) return -1;
		else if (stack2.isEmpty()) {
			while (!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		return stack2.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */