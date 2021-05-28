package com.leetcode.algorithm.No1438;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/22 12:22
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        if (len == 0) return 0;

        Deque<Integer> minQue = new LinkedList<>();
        Deque<Integer> maxQue = new LinkedList<>();

        int left = 0, right = 0;
        int max = 1;
        minQue.addLast(nums[0]);
        maxQue.addLast(nums[0]);

        while (true) {
            while (right != len - 1 && maxQue.peekFirst() - minQue.peekFirst() <= limit) {
                right++;
                addMaxQue(nums[right], maxQue);
                addMinQue(nums[right], minQue);
            }

            if (maxQue.peekFirst() - minQue.peekFirst() > limit) max = Math.max(max, right - left);
            else max = Math.max(max, right - left + 1);

            if (right == len - 1) break;
            if (maxQue.peekFirst() != null && maxQue.peekFirst() == nums[left]) maxQue.removeFirst();
            if (minQue.peekFirst() != null && minQue.peekFirst() == nums[left]) minQue.removeFirst();
            left++;
            right++;
            addMaxQue(nums[right], maxQue);
            addMinQue(nums[right], minQue);
        }

        return max;
    }

    public void addMaxQue(int num, Deque<Integer> maxQue) {
        while (maxQue.peekLast() != null && maxQue.peekLast() < num) maxQue.removeLast();
        maxQue.addLast(num);
    }

    public void addMinQue(int num, Deque<Integer> minQue) {
        while (minQue.peekLast() != null && minQue.peekLast() > num) minQue.removeLast();
        minQue.addLast(num);
    }
}