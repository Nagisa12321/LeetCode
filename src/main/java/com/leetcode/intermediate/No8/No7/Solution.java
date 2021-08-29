package com.leetcode.intermediate.No8.No7;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/2 11:18
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;

        boolean isPositive = (a >= 0 && b > 0) || (a < 0 && b < 0);
        if (a < 0) a = -a;
        if (b < 0) b = -b;

        // 整数部分
        long integer = a / b;
        long top = a;
        long down = integer * b;

        if (a % b == 0) return isPositive ? String.valueOf(integer) : String.valueOf(-integer);

        StringBuilder res = new StringBuilder();
        if (!isPositive) res.append("-");
        res.append(integer).append(".");
        var map = new HashMap<Long, Integer>();
        while (true) {
            top = (top - down) * 10;
            if (top == 0) break;

            // 一位
            int tmp = Math.toIntExact(top / b);

            down = tmp * b;

            if (!map.containsKey(top)) {
                map.replaceAll((k, v) -> v + 1);
                res.append(tmp);
                map.put(top, 1);
            } else {
                int idx = map.get(top);
                res.insert(res.length() - idx, '(');
                res.append(')');
                break;
            }

            if (res.length() >= Math.pow(10, 4)) break;
        }

        return res.toString();
    }
}