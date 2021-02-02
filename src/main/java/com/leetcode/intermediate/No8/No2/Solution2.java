package com.leetcode.intermediate.No8.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/31 11:42
 */
public class Solution2 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
