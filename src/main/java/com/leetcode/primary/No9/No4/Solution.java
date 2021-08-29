package com.leetcode.primary.No9.No4;

import java.util.LinkedList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/14 13:56
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tmpList = new LinkedList<>();
        tmpList.add(1);
        list.add(tmpList);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list1 = new LinkedList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) list1.add(1);
                else list1.add(tmpList.get(j - 2) + tmpList.get(j - 1));
            }
            tmpList = list1;
            list.add(tmpList);
        }
        return list;
    }
}
