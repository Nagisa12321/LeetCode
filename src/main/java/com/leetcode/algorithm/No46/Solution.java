package com.leetcode.algorithm.No46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/16 14:00
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> tmp = new ArrayList<>();
        track(list, tmp, nums);
        return list;
    }

    public void track(List<List<Integer>> list, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            list.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i])) continue;
            tmp.add(nums[i]);
            track(list, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}