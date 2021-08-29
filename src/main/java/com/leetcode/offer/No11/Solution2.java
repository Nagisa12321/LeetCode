package com.leetcode.offer.No11;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/16 15:05
 */
public class Solution2 {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return 0;
        else if (numbers.length == 1) return numbers[0];

        int left = 0, right = numbers.length - 1, lo = left, hi = right;

        if (numbers[left] == numbers[right]) {
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] < numbers[i - 1]) return numbers[i];
            }

            return numbers[0];
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (numbers[mid] <= numbers[right]) {
                hi = mid;
            } else if (numbers[mid] >= numbers[left]) {
                lo = mid + 1;
            }
        }

        return numbers[lo];
    }
}