package com.leetcode.advanced.arrayorstring.No10;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/26 9:37
 */
public class Solution2 extends Solution {
    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];

        // TreeMap<Integer, Integer> map = new TreeMap<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (i != 0)
                while (!deque.isEmpty() && deque.peekFirst() < nums[i])
                    deque.pollFirst();
            deque.addFirst(nums[i]);
        }

        for (int i = 0; i <= nums.length - k; i++) {
            if (i != 0) {
                if (!deque.isEmpty() && deque.peekLast() == nums[i - 1])
                    deque.pollLast();
                while (!deque.isEmpty() && deque.peekFirst() < nums[i + k - 1])
                    deque.pollFirst();
                deque.addFirst(nums[i + k - 1]);

            }
            res[i] = deque.peekLast();
        }
        return res;
    }
}
