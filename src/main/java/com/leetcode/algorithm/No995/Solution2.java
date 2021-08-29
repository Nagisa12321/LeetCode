package com.leetcode.algorithm.No995;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/23 11:33
 */
public class Solution2 {
    /*
        超时解决方案:
        用 N 表示数组 A 的长度。若直接模拟上述过程，复杂度将会是 O(NK) 的。如何优化呢？
        考虑不去翻转数字，而是统计每个数字需要翻转的次数。对于一次翻转操作，相当于把子数组中所有数字的翻转次数加 1。
     */
    public int minKBitFlips(int[] A, int K) {
        int len = A.length;
        int[] reserve = new int[len];
        int times = 0;
        for (int i = 0; i <= len - K; i++) {
            if (A[i] == 0) {
                int first_zero = reverse(A, i, K);
                times++;

            }
        }

        for (int i = len - K + 1; i < len; i++) {
            if (A[i] == 0) return -1;
        }

        return times;
    }

    public int reverse(int[] A, int left, int K) {

        return left;
    }
}
