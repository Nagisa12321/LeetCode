package com.leetcode.offer.No57.findcontinuoussequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 11:48
 */
public class Solution2 {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 1;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);

        while (right < target) {
            if (sum == target) {
                list.add(new ArrayList<>(tmp));

                right++;
                tmp.add(right);
                sum += right;
            } else if (sum < target) {
                right++;
                tmp.add(right);
                sum += right;
            } else {
                tmp.remove(0);
                sum -= left++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            int[] tmpArr = new int[list.get(i).size()];
            int idx = 0;

            for (int val : list.get(i))
                tmpArr[idx++] = val;
            res[i] = tmpArr;
        }

        return res;
    }
}
