package com.leetcode.offer.No59.slideWindows;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/9 9:54
 */
public class Solution2 {
    // 单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }

        assert deque.peekFirst() != null;
        res[0] = deque.peekFirst();

        int left = 0, right = k - 1;

        while (right < nums.length - 1) {
            if (nums[left] == deque.peekFirst())
                deque.remove(nums[left]);
            left++;
            right++;
            while (!deque.isEmpty() && deque.peekLast() < nums[right])
                deque.removeLast();
            deque.addLast(nums[right]);

            assert deque.peekFirst() != null;
            res[left] = deque.peekFirst();
        }
        return res;
    }
}
