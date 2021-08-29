package com.leetcode.algorithm.No39;

import java.util.ArrayList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/17 11:48
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        track(list, tmp, target, candidates, 0, 0);
        return list;
    }

    public void track(List<List<Integer>> list, List<Integer> tmp, int target, int[] candidates, int sum, int idx) {
        if (sum == target) list.add(new ArrayList<>(tmp));

        for (int i = idx; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum <= target)
                /*if (tmp.isEmpty() || candidates[i] >= tmp.get(tmp.size() - 1))*/ {
                tmp.add(candidates[i]);
                track(list, tmp, target, candidates, sum, i);
                tmp.remove(tmp.size() - 1);
            }
            sum -= candidates[i];
        }
    }
}