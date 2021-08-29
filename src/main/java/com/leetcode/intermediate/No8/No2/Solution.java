package com.leetcode.intermediate.No8.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/31 11:25
 */
public class Solution {
    public int trailingZeroes(int n) {
        int five = 0;
        for (int i = n; i > 0; i--){
            int tmp = i;
            while (true) {
                if (tmp % 5 == 0) {
                    five++;
                    tmp /= 5;
                } else break;
            }
        }
        return five;
    }
}