package com.leetcode.recursion.No5.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 18:26
 */
public class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1 && K == 1) return 0;
        if (K % 2 == 0) return kthGrammar(N - 1, K / 2) == 1 ? 0 : 1;
        else return kthGrammar(N - 1, (K + 1) / 2);
    }
}