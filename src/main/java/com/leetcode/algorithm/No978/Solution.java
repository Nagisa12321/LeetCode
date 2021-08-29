package com.leetcode.algorithm.No978;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 11:36
 */
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) return arr.length;
        int left = 0, right = 1;
        int len = arr.length;
        int max = arr[0] == arr[1] ? 1 : 2;

        while (right != len - 1) {
            while (arr[left] == arr[right] && right != len - 1) {
                left++;
                right++;
            }

            int states;
            if (arr[left] > arr[right]) states = 1;
            else states = 0;

            while (true) {
                if (right == len - 1) break;
                else if (isGoodNum(states, arr[right + 1], arr[right])) {
                    right++;
                    if (states == 1) states = 0;
                    else states = 1;
                } else {
                    left = right;
                    right++;
                    max = Math.max(right - left + 1, max);
                    break;
                }
                max = Math.max(right - left + 1, max);
            }
        }
        return max;
    }

    public boolean isGoodNum(int states, int nextNum, int thisNum) {
        if (states == 1) {
            return nextNum > thisNum;
        } else return thisNum > nextNum;
    }
}