package com.leetcode.recursion.No2.No1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/16 15:55
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        generateRow(1, numRows, new ArrayList<>(), list);
        return list;
    }

    public void generateRow(int row,
                            int numRows,
                            ArrayList<Integer> before,
                            List<List<Integer>> list) {
        if (row > numRows) return;

        var thisRow = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            if (i == 0 || i == row - 1) thisRow.add(1);
            else thisRow.add(before.get(i - 1) + before.get(i));
        }
        list.add(thisRow);
        generateRow(row + 1, numRows, thisRow, list);
    }
}