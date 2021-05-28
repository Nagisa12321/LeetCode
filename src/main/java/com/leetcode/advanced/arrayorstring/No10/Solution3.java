package com.leetcode.advanced.arrayorstring.No10;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/26 10:32
 */
public class Solution3 extends Solution {
    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];

        Node head = null;
        Node tail = null;

        for (int i = 0; i < k; i++) {
            // 尾部去掉元素直至没有任何元素比将进入元素大
            while (head != null && tail.val < nums[i]) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    tail = tail.prev;
                    tail.next = null;
                }
            }

            // 尾部添加
            if (head == null) {
                head = new Node(nums[i]);
                tail = head;
            } else {
                Node node = new Node(nums[i]);
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
            }
        }

        for (int i = 0; i <= nums.length - k; i++) {
            if (i != 0) {
                if (head != null && head.val == nums[i - 1]) {
                    if (head.next == null) {
                        head = null;
                        tail = null;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                }
                while (head != null && tail.val < nums[i + k - 1]) {
                    if (head == tail) {
                        head = null;
                        tail = null;
                    } else {
                        tail = tail.prev;
                        tail.next = null;
                    }
                }
                // 尾部添加
                if (head == null) {
                    head = new Node(nums[i + k - 1]);
                    tail = head;
                } else {
                    Node node = new Node(nums[i + k - 1]);
                    tail.next = node;
                    node.prev = tail;
                    tail = tail.next;
                }
            }
            res[i] = head.val;
        }
        return res;
    }

    private static class Node {
        Node next;
        Node prev;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            Node tmp = this;
            StringBuilder builder = new StringBuilder();
            builder.append('[');

            while (tmp != null) {
                builder.append(tmp.val);
                if (tmp.next == null) builder.append(']');
                else builder.append(", ");
                tmp = tmp.next;
            }

            return builder.toString();
        }
    }
}
