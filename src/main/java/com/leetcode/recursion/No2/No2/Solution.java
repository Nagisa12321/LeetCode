package com.leetcode.recursion.No2.No2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/16 16:04
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        int row = 1;
        List<Integer> thisRow = new ArrayList<>();
        List<Integer> beforeRow = new ArrayList<>();

        while (row <= rowIndex + 1) {
            thisRow = new ArrayList<Integer>();
            for (int i = 0; i < row; i++) {
                if (i == 0 || i == row - 1) thisRow.add(1);
                else thisRow.add(beforeRow.get(i - 1) + beforeRow.get(i));
            }

            beforeRow = thisRow;
            row++;
        }

        return thisRow;
    }
}