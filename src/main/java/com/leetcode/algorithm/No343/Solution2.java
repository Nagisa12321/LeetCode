package com.leetcode.algorithm.No343;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/9 15:53
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int integerBreak(int n) {
        int[] a = {0, 0, 1, 2, 4, 6, 9, 12, 18, 27, 36, 54, 81, 108, 162, 243,
                324, 486, 729, 972, 1458, 2187, 2916, 4374, 6561, 8748,
                13122, 19683, 26244, 39366, 59049, 78732, 118098, 177147,
                236196, 354294, 531441, 708588, 1062882, 1594323, 2125764,
                3188646, 4782969, 6377292, 9565938, 14348907, 19131876, 28697814,
                43046721, 57395628, 86093442, 129140163, 172186884, 258280326,
                387420489, 516560652, 774840978, 1162261467, 1549681956};
        return a[n];
    }
}
