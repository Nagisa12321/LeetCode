package com.leetcode.algorithm.No89;

import java.util.ArrayList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/19 19:58
 * @version 1.0
 ************************************************/
public class Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(head + list.get(j));
            }
            head <<= 1;
        }
        return list;
    }
}