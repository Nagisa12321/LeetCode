package com.leetcode.offer.No57.findcontinuoussequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 11:37
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 1;
        List<int[]> list = new ArrayList<>();

        while (right <= target / 2 + 1) {
            if (sum == target) {
                int[] tmp = new int[right - left + 1];
                for (int i = left; i <= right; i++)
                    tmp[i - left] = i;

                list.add(tmp);
                right++;
                sum += right;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left++;
            }
        }

        return list.toArray(int[][]::new);
    }
}