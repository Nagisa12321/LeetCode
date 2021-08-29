package com.leetcode.algorithm.No47;

import java.util.ArrayList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/21 11:23
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] map = new int[21];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) map[nums[i] + 10]++;
        track(list, new ArrayList<>(), map, nums.length);
        return list;
    }

    public void track(List<List<Integer>> list, List<Integer> tmp, int[] map, int len) {
        if (tmp.size() == len) {
            list.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < 21; i++) {
            if (map[i] > 0) {
                map[i]--;
                tmp.add(i - 10);
                track(list, tmp, map, len);
                tmp.remove(tmp.size() - 1);
                map[i]++;
            }
        }
    }
}