package com.leetcode.algorithm.No1018;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/14 16:29
 */
public class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        var res = new ArrayList<Boolean>();
        int sum = 0;
        for (int a : A) {
            sum = sum * 2 + a;
            res.add((sum % 5) == 0);
        }
        return res;
    }
}