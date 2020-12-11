package com.leetcode.algorithm.No650;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/10 12:59
 * @version 1.0
 ************************************************/
public class Solution {
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
