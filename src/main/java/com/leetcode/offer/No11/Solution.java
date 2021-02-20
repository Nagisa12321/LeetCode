package com.leetcode.offer.No11;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/16 14:25
 */
public class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return 0;
        else if (numbers.length == 1) return numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) return numbers[i];
        }

        return numbers[0];
    }
}