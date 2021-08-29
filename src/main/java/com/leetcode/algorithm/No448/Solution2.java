package com.leetcode.algorithm.No448;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/1 13:21
 * @version 1.0
 ************************************************/
public class Solution2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        if (nums.length == 0) return list;
        Arrays.sort(nums);
        int t = 1, i = 0;
        while (i != nums.length)
            if (nums[i] == t) {
                i++;
                t++;
            } else if (nums[i] < t)
                i++;
            else {
                list.add(t);
                t++;
            }
        while (t <= nums.length)
            list.add(t++);
        return list;
    }
}
