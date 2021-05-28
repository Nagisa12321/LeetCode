package com.leetcode.algorithm.No995;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/23 11:15
 */
public class Solution {
    // ³¬Ê±
    public int minKBitFlips(int[] A, int K) {
        int len = A.length;
        int times = 0;
        for (int i = 0; i <= len - K; i++) {
            if (A[i] == 0) {
                int first_zero = reverse(A, i, K);
                times++;
                if (first_zero == -1) i += K - 1;
                else i = first_zero - 1;
            }
        }

        for (int i = len - K + 1; i < len; i++) {
            if (A[i] == 0) return -1;
        }

        return times;
    }

    public int reverse(int[] A, int left, int K) {
        int first_zero = -1;
        for (int i = 0; i < K; i++) {
            A[i + left] = (A[i + left] + 1) % 2;
            if (A[i + left] == 0 && first_zero == -1) first_zero = i + left;
        }
        return first_zero;
    }
}