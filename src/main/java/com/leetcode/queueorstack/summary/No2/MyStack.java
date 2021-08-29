package com.leetcode.queueorstack.summary.No2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/3 11:29
 */
public class MyStack {
	private final Queue<Integer> queue1;
	private final Queue<Integer> queue2;
	private int enqueue = 1;

	/** Initialize your data structure here. */
	public MyStack() {
		queue1 = new LinkedList<>();
		queue2 = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		if (enqueue == 1) {
			queue1.offer(x);
		} else {
			queue2.offer(x);
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		int ret;
		if (enqueue == 1) {
			while (true) {
				int tmp = queue1.poll();
				if (queue1.isEmpty()) {
					ret = tmp;
					enqueue = 2;
					break;
				} else {
					queue2.offer(tmp);
				}
			}
		} else {
			while (true) {
				int tmp = queue2.poll();
				if (queue2.isEmpty()) {
					ret = tmp;
					enqueue = 1;
					break;
				} else {
					queue1.offer(tmp);
				}
			}
		}
		return ret;
	}

	/** Get the top element. */
	public int top() {
		int ret;
		if (enqueue == 1) {
			while (true) {
				int tmp = queue1.poll();
				if (queue1.isEmpty()) {
					ret = tmp;
					queue2.offer(tmp);
					enqueue = 2;
					break;
				} else {
					queue2.offer(tmp);
				}
			}
		} else {
			while (true) {
				int tmp = queue2.poll();
				if (queue2.isEmpty()) {
					ret = tmp;
					queue1.offer(tmp);
					enqueue = 1;
					break;
				} else {
					queue1.offer(tmp);
				}
			}
		}
		return ret;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */