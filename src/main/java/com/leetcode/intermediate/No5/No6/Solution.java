package com.leetcode.intermediate.No5.No6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/28 10:02
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        // 按左开端来排序
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        var list = new ArrayList<int[]>();
        // 遍历
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (right >= intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
            } else {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][]);
    }
}