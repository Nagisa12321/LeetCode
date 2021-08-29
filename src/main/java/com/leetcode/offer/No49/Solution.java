package com.leetcode.offer.No49;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/10 10:41
 */

// 超出时间限制
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(5);

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num = dp[i - 1] + 1;

            while (!isUglyNum(num, set))
                num++;
            dp[i] = num;
        }

        return dp[n - 1];
    }

    public boolean isUglyNum(int num, HashSet<Integer> set) {
        if (num == 2 || num == 3 || num == 5) return true;
        else if (num % 2 == 0) {
            if (set.contains(num / 2)) {
                set.add(num);
                return true;
            } else return false;
        } else if (num % 3 == 0) {
            if (set.contains(num / 3)) {
                set.add(num);
                return true;
            } else return false;
        } else if (num % 5 == 0) {
            if (set.contains(num / 5)) {
                set.add(num);
                return true;
            } else return false;
        }

        return false;
    }
}