package com.leetcode.algorithm.No89;

import java.util.ArrayList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/19 18:26
 * @version 1.0
 ************************************************/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        track(list, n, 0);
        return list;
    }

    public void track(List<Integer> list, int n, int num) {
        if (list.size() == Math.pow(2, n)
                || num > Math.pow(2, n) - 1
                ||list.contains(num)) return;
        else list.add(num);
        int tmp1 = num;
        for (int i = 0; i < n; i++) {
            if (tmp1 % 2 == 0) track(list, n, num + (int) Math.pow(2, i));
            else if (tmp1 % 2 == 1) track(list, n, num - (int) Math.pow(2, i));
            tmp1 >>= 1;
        }
    }
}