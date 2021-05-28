package com.leetcode.algorithm.No146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/9 20:46
 */
public class LRUCache {
	private ListNode head;
	private ListNode tail;
	private final Map<Integer, ListNode> map;
	private final int capacity;
	private int size;

	public LRUCache(int capacity) {
		this.head = null;
		this.tail = null;
		this.capacity = capacity;
		this.size = 0;
		this.map = new HashMap<>();
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		} else {
			ListNode cur = map.get(key);
			int result = cur.val;
			putBack(cur);
			return result;
		}
	}

	private void putBack(ListNode cur) {
		// 放到队尾
		// <= 1或者本来就是队尾什么也不用做.
		if (size > 1 && cur != tail) {
			// 消除原位置
			if (cur == head) {
				head = head.next;
				head.prev = null;
			} else {
				cur.next.prev = cur.prev;
				cur.prev.next = cur.next;
			}
			// 放到队尾
			tail.next = cur;
			cur.prev = tail;
			cur.next = null;
			tail = tail.next;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			ListNode cur = map.get(key);
			cur.val = value;
			putBack(cur);
		} else {
			if (size == capacity) {
				int headKey = head.key;
				head = head.next;
				if (head == null)
					tail = null;
				else
					head.prev = null;
				map.remove(headKey);
				size--;
			}

			// add tail
			ListNode node = new ListNode(key, value);
			map.put(key, node);
			if (head == null) {
				head = node;
				tail = head;
			} else {
				tail.next = node;
				node.prev = tail;
				tail = tail.next;
			}
			size++;
		}
	}

	private static class ListNode {
		int key;
		int val;
		ListNode prev;
		ListNode next;

		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */