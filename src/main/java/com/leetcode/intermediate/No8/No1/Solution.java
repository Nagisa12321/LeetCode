package com.leetcode.intermediate.No8.No1;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/31 11:10
 */
public class Solution {
    public boolean isHappy(int n) {
        // 一直循环直到在set中找到自身返回false
        var set = new HashSet<Integer>();
        int num = n;
        while (set.add(num)) {
            int tmp = 0;
            while (num != 0) {
                tmp += Math.pow((num % 10), 2);
                num /= 10;
            }
            num = tmp;
            if (num == 1) return true;
        }
        return false;
    }
}