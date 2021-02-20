package com.leetcode.algorithm.No1004;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/20 18:04
 */
public class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int len = A.length, size = 1;
        int one = 0, zero = 0;
        if (A[0] == 0) zero++;
        else one++;
        int max = 0;

        while (true) {
            while (right != len - 1 && size - K <= one ) {
                right++;
                size++;
                if (A[right] == 0) zero++;
                else one++;
            }

            if (size - K > one) max = Math.max(max, size - 1);
            else max = Math.max(max, size);

            if (A[left] == 0) zero--;
            else one--;
            left++;
            right++;
            if (right == len) break;
            else if (A[right] == 0) zero++;
            else one++;
        }

        return max;
    }
}